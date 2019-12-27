package com.volkodav4ik;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Group {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final int DAY_IN_WEEK = 7;
    private Courses courseName;
    private LocalDate dateOfBegin;
    private int duration;
    private int lessonWeek;
    public List<Person> students = new ArrayList<>();

    public Group(Courses courseName, LocalDate dateOfBegin, int duration, int lessonWeek) {
        this.courseName = courseName;
        this.dateOfBegin = dateOfBegin;
        this.duration = duration;
        this.lessonWeek = lessonWeek;
    }

    public String getName() {
        return courseName + " " + dateOfBegin.format(DATE_FORMAT);
    }

    public void printStudents() {
        System.out.println(getName());
        for (Person person : students) {
            System.out.println((students.indexOf(person) + 1) + ": " + person);
        }
    }

    public void addStudent(Person student) {
        students.add(student);
        student.addCourse(this);
    }

    public void deleteStudent(String lastName) {
        for (Person person : students) {
            if (person.getLastName().equals(lastName)) {
                students.remove(person);
                person.deleteCourse(this);
                break;
            }
        }
    }

    public void deleteStudent(int position) {
        int index = position - 1;
        try {
            students.get(index).deleteCourse(this);
            students.remove(index);
        } catch (Exception e) {
            System.out.println("Wrong number of position!");
        }
    }

    public String getLastWeek() {
        long daysToLastWeek = (this.duration / this.lessonWeek) * DAY_IN_WEEK - DAY_IN_WEEK;
        return "Date of first lesson in the last week of study of " + this.courseName + " course : "
                + this.dateOfBegin.plusDays(daysToLastWeek).format(DATE_FORMAT);
    }

    public String isStudentInGroup(String lastName) {
        for (Person person : students) {
            if (person.getLastName().equals(lastName)) {
                return "Student " + lastName + " is in " + this.courseName + " group";
            }
        }
        return "Student " + lastName + " isn't in " + this.courseName + " group";
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + courseName + '\'' +
                ", dateOfBegin='" + dateOfBegin + '\'' +
                ", duration=" + duration +
                ", lessonWeek=" + lessonWeek +
                ", students=" + students +
                '}';
    }


}
