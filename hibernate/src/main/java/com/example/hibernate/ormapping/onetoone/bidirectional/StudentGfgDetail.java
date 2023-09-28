package com.example.hibernate.ormapping.onetoone.bidirectional;

import com.example.hibernate.ormapping.onetoone.unidirectional.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentGfgDetail")
    private Student student;

    public StudentGfgDetail(String college, int noOfProblemsSolved) {
        this.college = college;
        this.noOfProblemsSolved = noOfProblemsSolved;
    }

    @Override
    public String toString() {
        return "StudentGfgDetail{" +
                "college='" + college + '\'' +
                ", noOfProblemsSolved=" + noOfProblemsSolved +
                '}';
    }
}
