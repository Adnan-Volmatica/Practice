package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
            Student Mariam = new Student(
                    1L,
                    LocalDate.of(2000, Month.JULY, 3),
                    "Mariam",
                    "Mariam@gmail.com"
            );

            Student Fatima = new Student(
                    LocalDate.of(2000, Month.NOVEMBER, 26),
                    "Fatima",
                    "fatima@gmail.com"
            );

            repository.saveAll(
                    List.of(Mariam,Fatima)
            );
        };
    }
}
