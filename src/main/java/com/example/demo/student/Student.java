//This is a student class that is used in different

package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;


@Entity //for mapping onto database/hibernate
@Table  //defined as a table of database
public class Student {
    @Id //makes "long id" the primary key
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )   //creates primary keys automatically
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    @Transient  //transient says age does not have to be a field in the database. It will be calculated from DOB
    private Integer age;    //Integer gives other properties and methods, while int only stores a whole number
    private LocalDate dob;
    private String name;
    private String email;

    public Student() {
    }

    public Student(long id,
                   LocalDate dob,
                   String name,
                   String email) {
        this.id = id;
        this.dob = dob;
        this.name = name;
        this.email = email;
    }

    public Student(LocalDate dob,
                   String name,
                   String email) // w/o id because it will be auto generated
    {
        this.dob = dob;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", dob=" + dob +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
