package com.demo.StudentManagementSystem.controller;

import com.demo.StudentManagementSystem.StudentManagementSystem_Entity.Student;
import com.demo.StudentManagement_service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home() {
		// Values added to the model are available in the Thymeleaf template
		return "home";    // view page --> html
	}

	@GetMapping("/students")
	public String getAllStudents(Model model){
                            //key                    show the data
		model.addAttribute("students", service.getAllStudents());
		return "students";
	}


	@GetMapping("students/new")
	public String createStudentForm(Model model){

		//creatte obj : to hold student obj or data
		Student students = new Student();
		model.addAttribute("students", students);          // to save data of the obj
	     return "create-student";                                         // same as html file same --> redirect
	}

	@PostMapping("/saveStudent")        // target ket "student"
	public String saveStudent(@ModelAttribute("student") Student student){

		 service.saveStudent(student);
		return "redirect:/students";

	}

		@GetMapping("/students/edit/{id}")        // target ket "student"
		public String editStudentForm(@PathVariable int id,Model model){
			model.addAttribute("student", service.getById(id));          // key must match ${student} in edit-student.html
			return "edit-student";                                         // same as html file same --> redirect
		}

	@PostMapping("/students/edit/{id}")        // receives the edit form submit
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student){

		Student existingStudent = service.getById(id);   // load the row (id already set)
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		service.updateStudent(existingStudent);          // keeps the id -> UPDATE, not INSERT
		return "redirect:/students";

	}

//	@{students/{id} (id=${student.id})}

	@GetMapping("/students/{id}")        // receives the edit form submit
	public String deleteById(@PathVariable int id){
		service.deleteById(id);          // keeps the id -> UPDATE, not INSERT
		return "redirect:/students";

	}


	@PostMapping("/addStudent")
	@ResponseBody
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
}