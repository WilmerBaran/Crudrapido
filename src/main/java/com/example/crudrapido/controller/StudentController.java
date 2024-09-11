package com.example.crudrapido.controller;

import com.example.crudrapido.entity.Student;
import com.example.crudrapido.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Obtener todos los estudiantes
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    // Obtener un estudiante por ID
    @GetMapping("/{studentId}")
    public Optional<Student> getStudentById(@PathVariable("studentId") Long studentId) {
        return studentService.getStudent(studentId);
    }

    // Guardar o actualizar un estudiante
    @PostMapping
    public void saveUpdate(@RequestBody Student student){
        studentService.saveOrUpdate(student);
    }

    // Eliminar un estudiante por ID
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.delete(studentId);
    }
}
