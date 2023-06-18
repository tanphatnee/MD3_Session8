package ra.service;

import ra.modal.Classes;

import java.util.ArrayList;

public class ClassService {
    private ArrayList<Classes> listClass = new ArrayList<Classes>();

    private SubjectService subjectService = new SubjectService();

    public ClassService() {
        listClass.add(new Classes(1, "JV03", subjectService.findById(1), false));
        listClass.add(new Classes(2, "JS04", subjectService.findById(2), false));
    }

    public ArrayList<Classes> getAll() {
        return listClass;
    }

    public int getSize() {
        return listClass.size();
    }

    public void save(Classes myClass) {
        if (findById(myClass.getId()) == null) {
            listClass.add(myClass);
            System.out.println("Thêm Thành công");
        } else {
            for (int i = 0; i < listClass.size(); i++) {
                if (listClass.get(i).getId() == myClass.getId()) {
                    listClass.set(i, myClass);
                }
            }
            System.out.println("Sửa Thành công");
        }
    }

    public void deleteClass(int id) {
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getId() == id) {
                listClass.remove(i);
            }
        }
        System.out.println("Xóa thành công");
    }

    public Classes findById(int id) {
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getId() == id) {
                return listClass.get(i);
            }
        }
        return null;
    }

    public int getNewId() {
        int idMax = 0;
        for (Classes c : listClass) {
            if (c.getId() > idMax) {
                idMax = c.getId();
            }
        }
        return idMax + 1;
    }
}
