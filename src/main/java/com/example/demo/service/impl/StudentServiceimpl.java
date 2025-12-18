package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    StudentRepo studentRep;

    @Override
    public Student insertStudent(Student st) {
        return studentRep.save(st);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRep.findAll();
    }

    @Override
    public Optional<Student> getOneStudent(Long id) {
        return studentRep.findById(id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRep.deleteById(id);
    }
}