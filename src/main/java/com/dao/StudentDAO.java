package com.dao;

import com.model.Student;
import java.util.List;
public interface StudentDAO {
    int saveStudent(Student student);
    int deleteStudent(int id);
    int updateStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudent();


}
