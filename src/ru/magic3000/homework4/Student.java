package ru.magic3000.homework4;

import java.util.Map;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> markByLessons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<String, Integer> getMarkByLessons() {
        return markByLessons;
    }

    public void setMarkByLessons(Map<String, Integer> markByLessons) {
        this.markByLessons = markByLessons;
    }
}
