package Exam_Advance;

import java.util.Scanner;

public class StudentSevice {
    public static Student[] students = new Student[100];
    public static int currentStudent = 0;
    static int id = 0;
    static Scanner sc = new Scanner(System.in);

    public StudentSevice() {
    }

    public static void studentManagement() {
        System.out.println("**********************STUDENT-MANAGEMENT************************\n" +
                "1.Thêm mới học sinh\t\t\t\t\t\t\t\t  \n" +
                "2.Hiển thị danh sách tất cả học sinh đã lưu trữ\t\t\t\t \n" +
                "3.Thay đổi thông tin học sinh theo mã id\t\t\t\t\t\n" +
                "4.Xóa học sinh theo mã id\t\t\t\t\t\t\t\t\t\n" +
                "5.Thoát\t");
        System.out.print("Nhập lựa chọn: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                showStudent();
                break;
            case 3:
                updateStudent();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                System.out.println("Quay trở lại menu!!");
                return;
            default:
                System.out.println("Yêu cầu nhập đúng trường 1 --> 5");
        }
    }

    // methods
    public static int getIndexById(int id) {
        int check = -1;
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getStudentId() == id) {
                check = i;
            }
        }
        return check;
    }

    public static void addStudent() {
        students[currentStudent] = new Student();
        students[currentStudent].inputData(sc, students, currentStudent, id);
        currentStudent++;
        id++;
        System.out.println("Thêm mới học sinh thành công!!");
    }

    // showStudent
    public static void showStudent() {
        System.out.println("DANH SÁCH HỌC SINH");
        if (students[0] == null) {
            System.out.println("Không có học sinh trong danh sách");
        } else {
            for (int i = 0; i < currentStudent; i++) {
                students[i].displayData();
            }
        }
    }

    // update
    public static void updateStudent() {
        sc.nextLine();
        System.out.print("Nhập id học sinh: ");
        int idUpdate = sc.nextInt();
        int index = getIndexById(idUpdate);
        if (index != -1) {
            do {
                sc.nextLine();
                System.out.println("Bạn có chắc là muốn cập nhập học sinh này? (y / n) ");
                students[index].displayData();
                System.out.print("Nhập lựa chọn: ");
                String choice = sc.next().toLowerCase();
                boolean isExit = true;
                switch (choice) {
                    case "y":
                        students[index].updateData(sc, students, currentStudent, idUpdate);
                        System.out.println("Sửa thông học sinh thành công!!");
                        break;
                    case "n":
                        break;
                    default:
                        isExit = false;
                        System.err.println("Yêu cầu chọn đúng định dạng y / n !!");
                }
                if (isExit) {
                    System.out.println("Thêm mới điểm thành công!!");
                    break;
                }
            } while (true);
        } else {
            System.out.println("Không tồn tại học sinh!!");
        }

    }

    // delete
    public static void deleteStudent() {
        sc.nextLine();
        System.out.print("Nhập id học sinh: ");
        int idUpdate = sc.nextInt();
        int index = getIndexById(idUpdate);
        if (index != -1) {
            do {
                sc.nextLine();
                System.out.println("Bạn có chắc là muốn xóa học sinh này? (y / n) ");
                students[index].displayData();
                System.out.print("Nhập lựa chọn: ");
                String choice = sc.nextLine().toLowerCase();
                boolean isExit = true;
                switch (choice) {
                    case "y":
                        for (int i = index; i < currentStudent; i++) {
                            students[i] = students[i + 1];
                        }
                        students[currentStudent] = null;
                        currentStudent--;
                        System.out.println("Đã xóa thành công!!");
                        break;
                    case "n":
                        break;
                    default:
                        isExit = false;
                        System.err.println("Yêu cầu chọn đúng định dạng y / n !!");
                }
                if (isExit) {
                    break;
                }
            } while (true);
        } else {
            System.out.println("Không tồn tại học sinh!!");
        }
    }
}
