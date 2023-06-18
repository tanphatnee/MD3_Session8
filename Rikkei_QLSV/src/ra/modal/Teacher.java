package ra.modal;

import ra.config.InputMethod;

import java.util.ArrayList;

public class Teacher extends User {
    private Classes myClass;
    private boolean status = true;

    public Teacher() {
    }

    public Teacher(Classes myClass, boolean status) {
        this.myClass = myClass;
        this.status = status;
    }

    public Teacher(int id, String username, String password, String fullName, String phoneNumber, String dob, Classes myClass, boolean status) {
        super(id, username, password, fullName, phoneNumber, dob);
        this.myClass = myClass;
        this.status = status;
    }

    public Classes getMyClass() {
        return myClass;
    }

    public void setMyClass(Classes myClass) {
        this.myClass = myClass;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(ArrayList<Classes> classes) {
        super.inputData();
        for (Classes c : classes) {
            System.out.println("--------------------------------");
            System.out.println("ID: " + c.getId() + " | ClassName: " + c.getClassName());
        }
        while (true) {
            System.out.print("Nhập vào ID lớp bạn muốn chọn: ");
            int id = InputMethod.getInteger();
            boolean flag = false;
            for (Classes c : classes) {
                if (c.getId() == id) {
                    this.myClass = c;
                    flag = true;
                }
            }
            if (!flag) {
                System.err.print("Không có lớp đó, Vui lòng nhập lại: ");
            } else {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nClass: " + myClass.getClassName();
    }
}
