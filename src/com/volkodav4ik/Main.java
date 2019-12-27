package com.volkodav4ik;

/*Написать методы:
        getName()- метод который выдает название группы на основе даты старта и названия курса
        getLastWeek()- метод который выдает дату старта последней недели курса
        printStudents()- печатает список студентов с порядковыми номерами
        addStudent() - добавить студента
        isStudentInGroup()- узнать если ли студент с такой фамилией в группе
        deleteStudent()- удалить студента по фамилии или по номеру*/

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Group java = new Group(Courses.JAVA, LocalDate.of(2019, 11, 06), 16, 2);
        Group js = new Group(Courses.JAVASCRIPT, LocalDate.of(2019, 12, 27), 30, 3);
        Group pm = new Group(Courses.PROJECT_MANAGEMENT, LocalDate.of(2020, 01, 8), 32, 2);

        Person st1 = new Person("Ivan", "Green", 19);
        Person st2 = new Person("Nicolas", "White", 27);
        Person st3 = new Person("Kirill", "Red", 35);
        Person st4 = new Person("Tatyana", "Yellow", 36);
        Person st5 = new Person("Vladimir", "Blue", 21);
        Person st6 = new Person("Anna", "Black", 23);
        Person st7 = new Person("Anastasia", "Brown", 30);
        Person st8 = new Person("Denis", "Orange", 42);
        Person st9 = new Person("Valery", "Purple", 35);
        Person st10 = new Person("Ibrahim", "Violet", 69);

        java.addStudent(st1);
        java.addStudent(st2);
        java.addStudent(st3);
        java.addStudent(st4);
        js.addStudent(st4);
        js.addStudent(st5);
        js.addStudent(st6);
        js.addStudent(st7);
        pm.addStudent(st8);
        pm.addStudent(st9);
        pm.addStudent(st10);
        pm.addStudent(st4);

        System.out.println(java.getName());
        System.out.println(js.getName());
        System.out.println(pm.getName());
        js.deleteStudent(1);
        pm.deleteStudent("Yellow");

        System.out.println(java.getLastWeek());
        System.out.println(js.getLastWeek());
        System.out.println(pm.getLastWeek());

        java.printStudents();
        js.printStudents();
        pm.printStudents();

        System.out.println(java.isStudentInGroup("Green"));
        System.out.println(java.isStudentInGroup("Black"));
    }

}
