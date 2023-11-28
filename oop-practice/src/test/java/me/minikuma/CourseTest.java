package me.minikuma;

import me.minikuma.course_grade.Course;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CourseTest {

    @Test
    @DisplayName("과목을 만든다")
    void createTest() {
        Assertions.assertThatCode(() -> new Course("이산수학", 3, "A+"))
                .doesNotThrowAnyException();
    }

}
