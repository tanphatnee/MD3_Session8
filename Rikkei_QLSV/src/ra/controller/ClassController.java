package ra.controller;

import ra.modal.Classes;
import ra.service.ClassService;

import java.util.ArrayList;

public class ClassController {
    private ClassService classService = new ClassService();

    public ArrayList<Classes> getAll() {
        return classService.getAll();
    }

    public int getSize() {
        return classService.getSize();
    }

    public void save(Classes myClass) {
        classService.save(myClass);
    }

    public void deleteClass(int id) {
        classService.deleteClass(id);
    }

    public Classes findById(int id) {
        return classService.findById(id);
    }

    public int getNewId() {
        return classService.getNewId();
    }
}
