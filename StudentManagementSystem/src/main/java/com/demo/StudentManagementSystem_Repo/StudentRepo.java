package com.demo.StudentManagementSystem_Repo;

import com.demo.StudentManagementSystem.StudentManagementSystem_Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                        //< entity name, id datatype>
public interface StudentRepo extends JpaRepository<Student, Integer> {
   

}
