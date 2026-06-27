package com.demo.StudentManagement_service;


import com.demo.StudentManagementSystem.StudentManagementSystem_Entity.Student;

import java.util.List;

public interface  StudentService {

         // retuen type list
  public List<Student> getAllStudents();

    Student addStudent(Student student);

    Student saveStudent(Student student);

   public Student getById(int id);

    public void deleteById(int id);

    Student updateStudent(Student student);

}