package dev.al.internship.controller;

import dev.al.internship.Repository.StudentRepository;
import dev.al.internship.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student newStudent) {
        Student s = studentRepository.findById(id).orElseThrow();
        s.setName(newStudent.getName());
        s.setAge(newStudent.getAge());
        return studentRepository.save(s);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}