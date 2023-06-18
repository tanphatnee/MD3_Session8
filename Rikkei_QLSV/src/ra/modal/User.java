package ra.modal;

import ra.config.InputMethod;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String dob;

    public User() {
    }

    public User(int id, String username, String password, String fullName, String phoneNumber, String dob) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void inputData() {
        System.out.print("Nhập username:  ");
        this.username = InputMethod.getString();
        System.out.print("Nhập password: ");
        this.password = InputMethod.getString();
        System.out.print("Nhập fullName: ");
        this.fullName = InputMethod.getString();
        System.out.print("Nhập phoneNumber: ");
        this.phoneNumber = InputMethod.getString();
        System.out.print("Nhập vào date of birthday: ");
        this.dob = InputMethod.getString();
    }

    @Override
    public String toString() {
        return "-----------------------------------------------------------------------------------------\n" +
                "ID: " + id + " | username: " + username + " | password: " + password + " | Name: " + fullName + " | DOB: " + dob + " | Phone: " + phoneNumber;
    }
}
