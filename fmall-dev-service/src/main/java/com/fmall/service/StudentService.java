package com.fmall.service;

import com.fmall.pojo.Student;

public interface StudentService {

    public void saveStudent();

    public Student getSudentInfo(int id);

    public void deleteStudent(int id);

    public void updateStudent(int id);

}
