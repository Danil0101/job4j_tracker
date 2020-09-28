package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
       return stream
               .flatMap(pupil -> pupil.getSubjects().stream())
               .mapToInt(Subject::getScore)
               .average()
               .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
       return stream
               .map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                       .mapToInt(Subject::getScore).average().orElse(0)))
               .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        Map<String, Double> map = stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)));

        return map.entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                        .mapToInt(Subject::getScore).sum()))
                .max((t1, t2) -> (int) (t1.getScore() - t2.getScore()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> map = stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)));

        return map.entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max((t1, t2) -> (int) (t1.getScore() - t2.getScore()))
                .orElse(null);
    }
}