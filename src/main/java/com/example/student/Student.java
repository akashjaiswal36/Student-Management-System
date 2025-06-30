package com.example.student;

public class Student {
    private int id;
    private String name;
    private String course;

    public Student() {} // default constructor required for Spring JSON binding

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // ✅ These are required
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    // Optional: Add setters if you're using form data or need to update values
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", Name:" + name + ", Course:" + course;
    }
}
