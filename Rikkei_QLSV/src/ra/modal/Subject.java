package ra.modal;

import ra.config.InputMethod;

public class Subject {
    private int id;
    private String subjectName;

    public Subject() {
    }

    public Subject(int id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void inputData() {
        System.out.print("Nhập vào tên môn học: ");
        this.subjectName = InputMethod.getString();
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Subject: " + subjectName;
    }
}
