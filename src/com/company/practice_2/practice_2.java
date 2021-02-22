package com.company.practice_2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class practice_2 {
    public static void main(String[] args) {
        List<Human> humanList = Arrays.asList(
                new Human(18, "Василий", "Деменьтьев", LocalDate.of(2002,9,13), 74),
                new Human(60, "Екатерина", "Горелова", LocalDate.of(1961, 6, 6), 49),
                new Human(20, "Алексей", "Зубкин", LocalDate.of(2001, 2, 20), 90),
                new Human(17, "Виктория", "Щукина", LocalDate.of(2004, 6, 5), 55),
                new Human(77, "Михаил", "Шапин", LocalDate.of(1944, 10, 3), 84),
                new Human(14, "Валерия", "Царапина", LocalDate.of(2007, 9, 30), 40));
        System.out.println("Сортировка по дате рождения:\n----------------");
        Stream<Human> stream = humanList.stream().sorted(Comparator.comparingInt(Human::getAge));
        stream.forEach(System.out::println);
        System.out.println("\nФильтрация по возрасту меньше, чем 50:\n----------------");
        stream = humanList.stream().filter(human -> human.getAge() < 50);
        stream.forEach(System.out::println);
        System.out.println("\nСортировка по весу:\n----------------");
        stream = humanList.stream().sorted(Comparator.comparingInt(Human::getWeight));
        stream.forEach(System.out::println);
        System.out.println("\nКонтакенция всех имен в большую строку через пробел:\n----------------");
        String all_names = humanList.stream().map(Human::getFirstName).collect(Collectors.joining(" "));
        System.out.println(all_names);
    }
}
