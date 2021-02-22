package com.company.practice_1;

import java.util.*;
import java.util.stream.Collectors;

class Student{
    String name;
    int group;

    public String getGroup() {
        return Integer.toString(group);
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return getName();
    }
    Student(String name, int group){
        this.name = name;
        this.group = group;
    }
}
public class practice_1 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("Аникин Пётр", 4),
                new Student("Деменьтев Виктор", 1),
                new Student("Щукина Алиса", 3),
                new Student("Носов Михаил", 2),
                new Student("Пушкин Алексей", 3),
                new Student("Лапина Анастасия", 4),
                new Student("Зубов Григорий", 1),
                new Student("Пилипчук Владислав", 2),
                new Student("Коровина Мария", 1),
                new Student("Дмитриев Степан", 1),
                new Student("Зайкин Николай", 3),
                new Student("Зуев Дмитрий", 4));

        Function<List<Student>, Map<String,List<Student>>> function = x -> x.stream().collect(Collectors.groupingBy(Student::getGroup));
        System.out.println(function.sort_students_by_group(list));
    }
}
