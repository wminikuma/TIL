package me.minikuma;

import me.minikuma.course_grade.Course;
import me.minikuma.course_grade.GradeCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * [Requirement]
 *  1. 평균 학점 계산 = (학점수 * 교과목 평점)의 합계 / 수강 신청 총학점 수
 *  2. 일급 컬렉션 사용
 */
class GradeCalculatorTest {
    // 학점 계산기: 이수 과목(이수한 과목명, 과목별 학점, 학점), 학점 계산기
    // 이수한 과목: 자료 구조, 이산 수학, 중국어 회화 -> 과목 클래스
    // 평균 학점: 이수한 과목 전달 > 평균 학점 계산 (학점 계산기 에게 요청)

    @Test
    @DisplayName("평균 학점을 계산 한다.")
    void calculatorGradeTest() {
        // 과목 만들기
        List<Course> courses = List.of(
                new Course("이산수학", 3, "A+"),
                new Course("자료구조", 3, "A+")
        );

        // 이수한 과목을 전달 해서 평균 학점을 계산
        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.gradeCalculator();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}
