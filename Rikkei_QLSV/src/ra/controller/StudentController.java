package ra.controller;

import ra.modal.Student;
import ra.service.StudentService;

import java.util.ArrayList;

public class StudentController {
    private StudentService studentService = new StudentService();

    public ArrayList<Student> getAll() {
        return studentService.getAll();
    }

    public int getSize() {
        return studentService.getSize();
    }

    public void save(Student student) {
        studentService.save(student);
    }

    public void deleteStudent(int id) {
        studentService.deleteStudent(id);
    }

    public Student findById(int id) {
        return studentService.findById(id);
    }

    public int getNewId() {
        return studentService.getNewId();
    }
}
