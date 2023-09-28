package com.example.hibernate.ormapping.onetoone.unidirectional;

import com.example.hibernate.ormapping.onetoone.unidirectional.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_gfg_detail")
public class StudentGfgDetail extends BaseEntity {
    private String college;
    private int noOfProblemsSolved;

    @Override
    public String toString() {
        return "StudentGfgDetail{" +
                "college='" + college + '\'' +
                ", noOfProblemsSolved=" + noOfProblemsSolved +
                '}';
    }
}
