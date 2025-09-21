package com.dev_tools.project_demonstartaion.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev_tools.project_demonstartaion.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}