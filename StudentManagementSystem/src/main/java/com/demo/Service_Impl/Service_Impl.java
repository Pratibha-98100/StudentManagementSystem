package com.demo.Service_Impl;

import com.demo.StudentManagementSystem.StudentManagementSystem_Entity.Student;
import com.demo.StudentManagementSystem_Repo.StudentRepo;
import com.demo.StudentManagement_service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Impl = implements
@Service
public class Service_Impl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> getAllStudents(){

    List<Student> list = studentRepo.findAll();         // findAll(); default datatype return list

    return list;
    }

    @Override
    public Student addStudent(Student student){
        // Force an INSERT: null id marks the entity as "new" so save() calls persist(), not merge().
        // Without this, sending an id (e.g. "id": 1) makes Hibernate try to UPDATE a non-existent
        // row -> StaleObjectStateException / ObjectOptimisticLockingFailureException.
        student.setId(null);
        return studentRepo.save(student);               // save(); inserts and returns the saved entity (with generated id)
    }

    @Override
    public Student saveStudent(Student student){
        // row -> StaleObjectStateException / ObjectOptimisticLockingFailureException.
        student.setId(null);
        return studentRepo.save(student);               // save(); inserts and returns the saved entity (with generated id)
    }
    @Override
    public Student getById(int id){
        // row -> StaleObjectStateException / ObjectOptimisticLockingFailureException.
        return studentRepo.findById(id).get();               // save(); inserts and returns the saved entity (with generated id)
    }

    @Override
    public void deleteById(int id){
          studentRepo.deleteById(id);               // removes the row with this id
    }

    @Override
    public Student updateStudent(Student student){
        // id is set, so save() does a merge() -> UPDATE of the existing row
        return studentRepo.save(student);
    }

}

