package ra.controller;

import ra.modal.Subject;
import ra.modal.Teacher;
import ra.service.SubjectService;

import java.util.ArrayList;

public class SubjectController {
    private SubjectService subjectService = new SubjectService();

    public ArrayList<Subject> getAll() {
        return subjectService.getAll();
    }

    public int getSize() {
        return subjectService.getSize();
    }

    public void save(Subject subject) {
        subjectService.save(subject);
    }

    public void deleteTeacher(int id) {
        subjectService.deleteSubject(id);
    }

    public Subject findById(int id) {
        return subjectService.findById(id);
    }

    public int getNewId() {
        return subjectService.getNewId();
    }
}
