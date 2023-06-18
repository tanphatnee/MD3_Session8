package ra.run;


import ra.config.InputMethod;
import ra.controller.ClassController;
import ra.controller.StudentController;
import ra.controller.SubjectController;
import ra.controller.TeacherController;
import ra.modal.Classes;
import ra.modal.Student;
import ra.modal.Subject;
import ra.modal.Teacher;

public class RikkeiAcademyManager {
    static final ClassController classController = new ClassController();
    static final SubjectController subjectController = new SubjectController();
    static final StudentController studentController = new StudentController();
    static final TeacherController teacherController = new TeacherController();

    public static void main(String[] args) {
        int choose = 0;
        while (choose != 4) {
            System.out.println("================== MENU RIKKEI ACADEMY ==============================");
            System.out.println("1. Quản Lý Học Viên");
            System.out.println("2. Quản Lý Giảng Viên");
            System.out.println("3. Quản Lý Lớp");
            System.out.println("4. Thoát");
            System.out.println("=====================================================================");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    // Manager Student
                    menuManagerStudent();
                    break;
                case 2:
                    // Manager Teacher
                    menuManagerTeacher();
                    break;
                case 3:
                    // Manager Classes
                    menuManagerClass();
                    break;
                case 4:
                    // out
                    System.out.println("~~ CẢM ƠN BẠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH ~~");
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn lại (1 -> 4)");
                    break;
            }
        }
    }

    // ======================= menu manager students ===========================
    public static void menuManagerStudent() {
        int choose = 0;
        while (choose != 6) {
            System.out.println("======================= MENU MANAGER STUDENTS ========================");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Hiển thị sinh viên theo lớp");
            System.out.println("3. Thêm học viên");
            System.out.println("4. Xem chi tiết học viên");
            System.out.println("5. Tìm kiếm học viên theo tên");
            System.out.println("6. Quay lại");
            System.out.println("======================================================================");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    // show list students
                    showListStudent();
                    break;
                case 2:
                    // show list students by class
                    showListStudentByClass();
                    break;
                case 3:
                    // add item student
                    addNewStudent();
                    break;
                case 4:
                    // show item students
                    showInformationStudent();
                    break;
                case 5:
                    // search students
                    searchStudent();
                    break;
                case 6:
                    // out
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn lại (1 -> 6)");
                    break;
            }
        }
    }

    public static void showListStudent() {
        if (studentController.getSize() == 0) {
            System.err.println("Không có sinh viên nào");
            return;
        }
        for (Student s : studentController.getAll()) {
            System.out.println("ID: " + s.getId() + " | Fullname: " + s.getFullName() + " | Class: " + s.getMyClass().getClassName());
        }
    }

    public static void showListStudentByClass() {
        for (Classes c : classController.getAll()) {
            System.out.println(c);
        }
        while (true) {
            System.out.print("Bạn muốn chọn ID lớp nào: ");
            int id = InputMethod.getInteger();
            Classes myClass = classController.findById(id);
            if (myClass != null) {
                boolean flag = false;
                for (Student s : studentController.getAll()) {
                    if (s.getMyClass().getClassName().equals(myClass.getClassName()) && s.isStatus() == false) {
                        flag = true;
                        System.out.println("ID: " + s.getId() + " | Fullname: " + s.getFullName() + " | Class: " + s.getMyClass().getClassName());
                    }
                }
                if (!flag) {
                    System.err.println("Không có sinh viên nào");
                }
                break;
            } else {
                System.err.println("Không tìm thấy, vui lòng nhập lại: ");
            }
        }
    }

    public static void addNewStudent() {
        System.out.print("Bạn muốn thêm bao nhiêu sinh viên: ");
        int n = InputMethod.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên thứ " + (i + 1));
            Student newStudent = new Student();
            newStudent.setId(studentController.getNewId());
            newStudent.inputData(classController.getAll());
            studentController.save(newStudent);
        }
    }

    public static void showInformationStudent() {
        Student student;
        int id;
        while (true) {
            System.out.print("Bạn muốn chọn ID sinh viên nào: ");
            id = InputMethod.getInteger();
            student = studentController.findById(id);
            if (student != null) {
                System.out.println("ID: " + student.getId() + " | Fullname: " + student.getFullName() + " | Class: " + student.getMyClass().getClassName());
                System.out.println("-----------------------------------------------------------------------------------------");
                break;
            } else {
                System.err.println("Không có sinh viên đó");
            }
        }
        int choose;
        while (true) {
            System.out.println("===================================");
            System.out.println("1. Sửa Thông Tin Sinh Viên");
            System.out.println("2. Xóa Thông Tin Sinh Viên");
            System.out.println("===================================");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    editInformationStudent(student);
                    break;
                case 2:
                    deleteStudent(id);
                    break;
                default:
                    System.err.println("Vui lòng nhập lại (1 -> 2)");
                    break;
            }
            if (choose == 1 || choose == 2) {
                break;
            }
        }
    }

    public static void editInformationStudent( Student student) {
        student.inputData();
        studentController.save(student);
    }

    public static void deleteStudent(int id) {
        studentController.deleteStudent(id);
    }

    public static void searchStudent() {
        System.out.print("Nhập vào tên sinh viên bạn muốn tìm: ");
        String text = InputMethod.getString();
        text.toLowerCase();
        boolean flag = false;
        if (text.trim().equals("")) {
            System.err.println("Nhập không hợp lệ");
            return;
        }
        for (Student s : studentController.getAll()) {
            if (s.getUsername().toLowerCase().contains(text)) {
                flag = true;
                System.out.println("ID: " + s.getId() + " | Fullname: " + s.getFullName() + " | Class: " + s.getMyClass().getClassName());
            }
        }
        if (!flag) {
            System.err.println("Không tồn tại sinh viên đó");
        } else {
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    // ======================= menu manager teachers ===========================
    public static void menuManagerTeacher() {
        int choose = 0;
        while (choose != 5) {
            System.out.println("======================= MENU MANAGER TEACHERS ========================");
            System.out.println("1. Hiển thị tất cả giảng viên");
            System.out.println("2. Hiển thị giảng viên theo lớp");
            System.out.println("3. Thêm giảng viên (1 lần 1 lượt)");
            System.out.println("4. Xem chi tiết giảng viên");
            System.out.println("5. Quay lại");
            System.out.println("======================================================================");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    // show list teachers
                    showListTeacher();
                    break;
                case 2:
                    // show item teacher
                    showTeacherByClass();
                    break;
                case 3:
                    // add teacher
                    addNewTeacher();
                    break;
                case 4:
                    // show more information teacher
                    showInformationTeacher();
                    break;
                case 5:
                    // out
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn lại (1 -> 5)");
                    break;
            }
        }
    }

    public static void showListTeacher() {
        if (teacherController.getSize() == 0) {
            System.err.println("Không có giảng viên nào");
            return;
        }
        for (Teacher t : teacherController.getAll()) {
            System.out.println("ID: " + t.getId() + " | Fullname: " + t.getFullName() + " | Class: " + t.getMyClass().getClassName());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void showTeacherByClass() {
        for (Classes c : classController.getAll()) {
            System.out.println(c);
        }
        while (true) {
            System.out.print("Bạn muốn chọn ID lớp nào: ");
            int id = InputMethod.getInteger();
            Classes myClass = classController.findById(id);
            if (myClass != null) {
                boolean flag = false;
                for (Teacher t : teacherController.getAll()) {
                    if (t.getMyClass().getId() == myClass.getId() && t.isStatus() == true) {
                        flag = true;
                        System.out.println("ID: " + t.getId() + " | Fullname: " + t.getFullName() + " | Class: " + t.getMyClass().getClassName());
                    }
                }
                if (!flag) {
                    System.err.println("Không có giảng viên nào");
                } else {
                    System.out.println("-----------------------------------------------------------------------------------------");
                }
                break;
            } else {
                System.err.println("Không tìm thấy, vui lòng nhập lại: ");
            }
        }
    }

    public static void addNewTeacher() {
        Teacher newTeacher = new Teacher();
        newTeacher.setId(teacherController.getNewId());
        newTeacher.inputData(classController.getAll());
        teacherController.save(newTeacher);
    }

    public static void showInformationTeacher() {
        Teacher teacher;
        int id;
        while (true) {
            System.out.print("Bạn muốn chọn ID giảng viên nào: ");
            id = InputMethod.getInteger();
            teacher = teacherController.findById(id);
            if (teacher != null) {
                System.out.println(teacher);
                System.out.println("-----------------------------------------------------------------------------------------");
                break;
            } else {
                System.err.println("Không có giảng viên đó");
            }
        }
        int choose;
        while (true) {
            System.out.println("===================================");
            System.out.println("1. Xóa Thông Tin Giảng vin");
            System.out.println("2. Sửa Thông Tin Giảng viên");
            System.out.println("===================================");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    deleteTeacher(id);
                    break;
                case 2:
                    editInformationTeacher(teacher);
                    break;
                default:
                    System.err.println("Vui lòng nhập lại (1 -> 2)");
                    break;
            }
            if (choose == 1 || choose == 2) {
                break;
            }
        }
    }

    public static void deleteTeacher(int id) {
        teacherController.deleteTeacher(id);
    }

    public static void editInformationTeacher( Teacher teacher) {
        teacher.inputData();
        teacherController.save(teacher);
    }

    // ========================  menu manager class  ===========================
    public static void menuManagerClass() {
        int choose = 0;
        while (choose != 6) {
            System.out.println("========================== MENU MANAGER CLASSES ===========================");
            System.out.println("1. Hiển thị tất cả các lớp");
            System.out.println("2. Thêm Lớp Học");
            System.out.println("3. Hiển thị lớp theo chuyên môn");
            System.out.println("4. Xem chi tiết lớp");
            System.out.println("5. Thay đổi trạng thái lớp");
            System.out.println("6. Quay lại");
            System.out.println("===========================================================================");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    // show list class
                    showListClass();
                    break;
                case 2:
                    // add new class
                    addNewClass();
                    break;
                case 3:
                    // show item class by subject
                    showCLassBySubject();
                    break;
                case 4:
                    // xem chi tiết lớp
                    showInformationClass();
                    break;
                case 5:
                    // thay đổi trang thái lớp
                    changeModeClass();
                    break;
                case 6:
                    // out
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn lại (1 -> 5)");
                    break;
            }
        }
    }

    public static void showListClass() {
        if (classController.getSize() == 0) {
            System.err.println("Không có lớp nào");
            return;
        }
        for (Classes c : classController.getAll()) {
            if (c.isStatus() == false) {
                System.out.println(c);
            }
        }
    }

    public static void addNewClass() {
        Classes newClass = new Classes();
        newClass.setId(classController.getNewId());
        newClass.inputData(subjectController.getAll());
        classController.save(newClass);
    }

    public static void showCLassBySubject() {
        for (Subject subject : subjectController.getAll()) {
            System.out.println(subject);
        }
        while (true) {
            System.out.print("Bạn chọn ID môn học nào: ");
            int id = InputMethod.getInteger();
            Subject subject = subjectController.findById(id);
            if (subject != null) {
                boolean flag = false;
                for (Classes c : classController.getAll()) {
                    if (c.getSubject().getId() == subject.getId()) {
                        flag = true;
                        System.out.println(c);
                    }
                }
                if (!flag) {
                    System.err.println("Không có lớp nào");
                }
                break;
            } else {
                System.err.println("Không tìm thấy, Vui lòng nhập lại: ");
            }
        }
    }

    public static void showInformationClass() {
        Classes myClass;
        while (true) {
            System.out.print("Bạn muốn xem thông tin ID lớp nào: ");
            int id = InputMethod.getInteger();
            myClass = classController.findById(id);
            if (myClass != null) {
                System.out.println(myClass);
                break;
            }
        }
        int choose = 0;
        while (choose != 3) {
            System.out.println("================================");
            System.out.println("1. Xem danh sách học viên trong lớp");
            System.out.println("2. Xem danh sách giảng viên trong lớp");
            System.out.println("3. Quay lại");
            System.out.println("================================");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    showListStudentByClass(myClass);
                    break;
                case 2:
                    showTeacherByClass(myClass);
                    break;
                case 3:
                    // out
                    break;
                default:
                    System.err.println("Vui lòng nhập lại (1 -> 3)");
                    break;
            }
        }

    }

    public static void showListStudentByClass(Classes myClass) {
        boolean flag = false;
        for (Student s : studentController.getAll()) {
            if (s.getMyClass().getClassName().equals(myClass.getClassName()) && s.isStatus() == false) {
                flag = true;
                System.out.println("ID: " + s.getId() + " | Fullname: " + s.getFullName() + " | Class: " + s.getMyClass().getClassName());
            }
        }
        if (!flag) {
            System.err.println("Không có sinh viên nào");
        }
    }

    public static void showTeacherByClass(Classes myClass) {
        boolean flag = false;
        for (Teacher t : teacherController.getAll()) {
            if (t.getMyClass().getId() == myClass.getId() && t.isStatus() == true) {
                flag = true;
                System.out.println(t);
            }
        }
        if (!flag) {
            System.err.println("Không có giảng viên nào");
        } else {
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    public static void changeModeClass() {
        while (true) {
            System.out.print("Bạn muốn thay đổi trang thái ID lớp nào: ");
            int id = InputMethod.getInteger();
            Classes myClass = classController.findById(id);
            if (myClass != null) {
                myClass.setStatus(!myClass.isStatus());
                break;
            }
            System.err.println("Không tìm thấy, Vui lòng nhập lại: ");
        }
    }

}
