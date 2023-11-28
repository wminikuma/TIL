package me.minikuma.course_grade;

public class Course {
    private final String subject; // 과목명
    private final int credit; // 학점
    private final String grade; // 성적

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return this.credit;
    }

    public double getGradeToNumber() {
        double gradeScore;

        switch (this.grade) {
            case "A+":
                gradeScore = 4.5;
                break;
            case "A":
                gradeScore = 4.0;
                break;
            case "B+":
                gradeScore = 3.5;
                break;
            case "B":
                gradeScore = 3.0;
                break;
            case "C+":
                gradeScore = 2.5;
                break;
            case "C":
                gradeScore = 2.0;
                break;
            case "D+":
                gradeScore = 1.5;
                break;
            case "D":
                gradeScore = 1.0;
                break;
            default:
                gradeScore = 0.0;
                break;
        }
        return gradeScore;
    }

    public double multipliedCreditAndCourseGrade() {
        return credit * getGradeToNumber();
    }
}
