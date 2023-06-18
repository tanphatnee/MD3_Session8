package ra.service;

import ra.modal.Teacher;


import java.util.ArrayList;

public class TeacherService {
    private ArrayList<Teacher> listTeacher = new ArrayList<Teacher>();

    private ClassService classService = new ClassService();

    public TeacherService() {
        listTeacher.add(new Teacher(1, "vudai", "123", "pham vu dai", "098765", "12/12/1997", classService.findById(1), true));
        listTeacher.add(new Teacher(2, "hunghx", "456", "ho xuan hung", "0987654", "12/12/1999", classService.findById(1), true));
        listTeacher.add(new Teacher(3, "beccop", "789", "nguyen xuan bec", "09876543", "12/12/1991", classService.findById(2), true));
    }

    public ArrayList<Teacher> getAll() {
        return listTeacher;
    }

    public int getSize() {
        return listTeacher.size();
    }

    public void save(Teacher teacher) {
        if (findById(teacher.getId()) == null) {
            listTeacher.add(teacher);
            System.out.println("Thêm thành công");
        } else {
            for (int i = 0; i < getSize(); i++) {
                if (listTeacher.get(i).getId() == teacher.getId()) {
                    listTeacher.set(i, teacher);
                }
            }
            System.out.println("Sửa thành công");
        }
    }

    public void deleteTeacher(int id) {
        for (int i = 0; i < getSize(); i++) {
            if (listTeacher.get(i).getId() == id) {
                listTeacher.remove(i);
            }
        }
        System.out.println("Xóa thành công");
    }

    public Teacher findById(int id) {
        for (int i = 0; i < getSize(); i++) {
            if (listTeacher.get(i).getId() == id) {
                return listTeacher.get(i);
            }
        }
        return null;
    }

    public int getNewId() {
        int idMax = 0;
        for (Teacher s : listTeacher) {
            if (s.getId() > idMax) {
                idMax = s.getId();
            }
        }
        return idMax + 1;
    }
}
