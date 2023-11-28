package me.minikuma.course_grade;

import java.util.List;

public class Courses {
    private final List<Course> courseList;

    public Courses(List<Course> courses) {
        this.courseList = courses;
    }

    public double sumAfterMultiplyCreditAndCourseGrade() {
        double sumAfterMultiplyCreditAndCourseGrade = 0.0;
        for (Course course : courseList) {
            sumAfterMultiplyCreditAndCourseGrade += course.multipliedCreditAndCourseGrade();
        }
        return sumAfterMultiplyCreditAndCourseGrade;
    }

    public int totalCompletedCredit() {
        return courseList.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
