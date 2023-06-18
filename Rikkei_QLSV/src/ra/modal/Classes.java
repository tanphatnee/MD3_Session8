package ra.modal;

import ra.config.InputMethod;

import java.util.ArrayList;

public class Classes {
    private int id;
    private String className;
    private Subject subject;
    private boolean status = false;

    public Classes() {
    }

    public Classes(int id, String className, Subject subject, boolean status) {
        this.id = id;
        this.className = className;
        this.subject = subject;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(ArrayList<Subject> subjects) {
        System.out.print("Nhập vào tên lớp: ");
        this.className = InputMethod.getString();
        for (Subject s : subjects) {
            System.out.println("--------------------------------");
            System.out.println("ID: " + s.getId() + " | SubjectName: " + s.getSubjectName());
        }
        while (true) {
            System.out.print("Nhập vào ID môn học bạn muốn chọn: ");
            int id = InputMethod.getInteger();
            boolean flag = false;
            for (Subject s : subjects) {
                if (s.getId() == id) {
                    this.subject = s;
                    flag = true;
                }
            }
            if (!flag) {
                System.err.print("Không có môn học đó, Vui lòng nhập lại: ");
            } else {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Class: " + className + " | Subject: " + subject.getSubjectName();
    }
}
