package org.example.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private String name;
    private Integer age;
    private String sex;
    private String subject;
    private Integer salary;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", subject='" + subject + '\'' +
                ", salary=" + salary +
                '}' + "\n";
    }

}
