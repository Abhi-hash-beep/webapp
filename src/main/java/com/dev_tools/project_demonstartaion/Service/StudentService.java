package com.dev_tools.project_demonstartaion.Service;






import java.util.List;

import com.dev_tools.project_demonstartaion.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    void deleteStudentById(Long id);
}
