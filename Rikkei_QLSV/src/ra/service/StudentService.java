package ra.service;

import ra.modal.Classes;
import ra.modal.Student;

import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> listStudent = new ArrayList<Student>();

    private ClassService classService = new ClassService();
    private SubjectService subjectService = new SubjectService();

    public StudentService() {
        listStudent.add(new Student(1, "haidang", "hai1", "pham trung hai", "0951", "22/12/1992", subjectService.findById(1), classService.findById(1), false));
        listStudent.add(new Student(2, "huytran", "huy1", "tran huu huy", "0948", "22/12/1998", subjectService.findById(1), classService.findById(1), false));
        listStudent.add(new Student(3, "binhpham", "binh1", "pham tuan binh", "0955", "22/12/2001", subjectService.findById(1), classService.findById(1), false));
    }

    public ArrayList<Student> getAll() {
        return listStudent;
    }

    public int getSize() {
        return listStudent.size();
    }

    public void save(Student student) {
        if (findById(student.getId()) == null) {
            listStudent.add(student);
            System.out.println("Thêm thành công");
        } else {
            for (int i = 0; i < getSize(); i++) {
                if (listStudent.get(i).getId() == student.getId()) {
                    listStudent.set(i, student);
                }
            }
            System.out.println("Sửa thành công");
        }
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < getSize(); i++) {
            if (listStudent.get(i).getId() == id) {
                listStudent.remove(i);
            }
        }
        System.out.println("Xóa thành công");
    }

    public Student findById(int id) {
        for (int i = 0; i < getSize(); i++) {
            if (listStudent.get(i).getId() == id) {
                return listStudent.get(i);
            }
        }
        return null;
    }

    public int getNewId() {
        int idMax = 0;
        for (Student s : listStudent) {
            if (s.getId() > idMax) {
                idMax = s.getId();
            }
        }
        return idMax + 1;
    }
}
