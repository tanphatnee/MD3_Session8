package ra.service;

import ra.modal.Subject;
import ra.modal.Subject;

import java.util.ArrayList;

public class SubjectService {
    private ArrayList<Subject> listSubject = new ArrayList<Subject>();

    public SubjectService() {
        listSubject.add(new Subject(1, "Java"));
        listSubject.add(new Subject(2, "JavaScript"));
    }

    public ArrayList<Subject> getAll() {
        return listSubject;
    }
    public int getSize() {
        return listSubject.size();
    }

    public void save(Subject subject) {
        if (findById(subject.getId()) == null) {
            listSubject.add(subject);
            System.out.println("Thêm thành công");
        } else {
            for (int i = 0; i < getSize(); i++) {
                if (listSubject.get(i).getId() == subject.getId()) {
                    listSubject.set(i, subject);
                }
            }
            System.out.println("Sửa thành công");
        }
    }

    public void deleteSubject(int id) {
        for (int i = 0; i < getSize(); i++) {
            if (listSubject.get(i).getId() == id) {
                listSubject.remove(i);
            }
        }
        System.out.println("Xóa thành công");
    }

    public Subject findById(int id) {
        for (int i = 0; i < getSize(); i++) {
            if (listSubject.get(i).getId() == id) {
                return listSubject.get(i);
            }
        }
        return null;
    }

    public int getNewId() {
        int idMax = 0;
        for (Subject s : listSubject) {
            if (s.getId() > idMax) {
                idMax = s.getId();
            }
        }
        return idMax + 1;
    }
}
