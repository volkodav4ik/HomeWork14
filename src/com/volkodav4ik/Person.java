package com.volkodav4ik;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String lastName;
    public List<Group> group = new ArrayList<>();
    private int age;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getStudentsCourses() {
        StringBuilder coursesList = new StringBuilder();
        for (Group group : group) {
            coursesList.append(group.getName()).append("; ");
        }
        coursesList.delete(coursesList.length() - 2, coursesList.length());
        return coursesList.toString();
    }

    public String getLastName() {
        return lastName;
    }

    public void addCourse(Group group) {
        this.group.add(group);
    }

    public void deleteCourse(Group group) {
        this.group.remove(group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name: " + name + " " + lastName +
                ", age: " + age +
                ", course list: " + getStudentsCourses() +
                '}';
    }
}
