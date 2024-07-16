//this class contains the controller that fetches the business logic from the studentService class

package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")    //instead of localhost:8080 now the endpoint is hit at localhost:8080/api/v1/student
public class StudentController {

    private final StudentService studentService;

    @Autowired  //dependency injection. Automatically creates an instance of the required class
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }







}
