package com.dev_tools.project_demonstartaion.Controller;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev_tools.project_demonstartaion.Service.StudentService;
import com.dev_tools.project_demonstartaion.entity.Student;

@Controller
public class StudentController {
	
	 private final StudentService studentService;
	
	public StudentController(StudentService studentService) {

		   this.studentService = studentService;
		}

  

    // Handler for the welcome page
    @GetMapping("/")
    public String viewWelcomePage() {
        return "welcome";
    }

    // Handler to display the list of students
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    // Handler to show the form for adding a new student
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student_form";
    }

    // Handler to save a new student
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Handler to show the form for editing a student
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student_form";
    }

    // Handler to update a student's information
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        // Get existing student from database
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setName(student.getName());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        existingStudent.setBranch(student.getBranch());

        // Save updated student object
        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    // Handler to delete a student
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
