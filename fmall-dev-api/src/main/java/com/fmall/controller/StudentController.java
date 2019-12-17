package com.fmall.controller;

import com.fmall.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudent")
    public Object getStudent(int id) {
        return  studentService.getSudentInfo(id);
    }
}
