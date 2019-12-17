package com.fmall.service.impl;

import com.fmall.mapper.StudentMapper;
import com.fmall.pojo.Student;
import com.fmall.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void saveStudent() {

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Student getSudentInfo(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public void updateStudent(int id) {
    }
}
