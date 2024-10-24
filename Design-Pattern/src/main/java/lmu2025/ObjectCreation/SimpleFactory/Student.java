package lmu2025.ObjectCreation.SimpleFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author leenadz
 * @since 2024-10-12 10:04
 */
@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String name;
    private Integer age;
    private Integer height;

    public static Student createStudent(String name, Integer age) {
        return new Student(name, age, null);
    }

    public static Student createPlayer(String name, Integer height) {
        return new Student(name, null, height);
    }
}
