package com.example.student;

public class Student {
    private int id;
    private String name;
    private String course;

    // constructors, getters, setters omitted for brevity
    public Student() { }                         // needed for JSON binding
    public Student(int id, String name, String course) {
        this.id = id; this.name = name; this.course = course;
    }
    // getters & setters …
    @Override public String toString() {
        return "ID:" + id + ", Name:" + name + ", Course:" + course;
    }
}
