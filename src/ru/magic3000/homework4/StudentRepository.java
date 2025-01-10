package ru.magic3000.homework4;

import java.util.List;
import java.util.function.Function;

public class StudentRepository {
    public void transferOrExpelStudent(List<Student> students) {
        students.removeIf(student -> {
            var avg = student.getMarkByLessons()
                    .values()
                    .stream()
                    .mapToDouble(Integer::doubleValue)
                    .average()
                    .orElse(0);
            return avg < 3.0;
        });
        students.forEach(student -> {
            student.setCourse(student.getCourse() + 1);
        });
    }

    public void printStudents(List<Student> students, int course) {
        students.forEach(student -> {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        });
    }
}
