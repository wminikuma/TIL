package me.minikuma.course_grade;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double gradeCalculator() {
        return courses.sumAfterMultiplyCreditAndCourseGrade() / courses.totalCompletedCredit();
    }
}
