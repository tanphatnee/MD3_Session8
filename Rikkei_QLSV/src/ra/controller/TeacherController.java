package ra.controller;

import ra.modal.Teacher;
import ra.service.TeacherService;

import java.util.ArrayList;

public class TeacherController {
    private TeacherService teacherService = new TeacherService();

    public ArrayList<Teacher> getAll() {
        return teacherService.getAll();
    }

    public int getSize() {
        return teacherService.getSize();
    }

    public void save(Teacher teacher) {
        teacherService.save(teacher);
    }

    public void deleteTeacher(int id) {
        teacherService.deleteTeacher(id);
    }

    public Teacher findById(int id) {
        return teacherService.findById(id);
    }

    public int getNewId() {
        return teacherService.getNewId();
    }
}
