package Exam_Advance;

import java.util.Scanner;

public class MarkService {
    static Mark[] marks = new Mark[100];
    static int currentMark = 0;
    static int markId = 0;
    static Scanner sc = new Scanner(System.in);

    public static void markManagement() {
        System.out.println(" *********************MARK-MANAGEMENT************************\n" +
                "1.Thêm mới điểm thi cho 1 sinh viên\t\t\t\t\t\t\n" +
                "2.Hiển thị danh sách tất cả điểm thi \t\t    \n" +
                "3.Thay đổi điểm theo mã id\t\t\t\t\t\t\t\n" +
                "4.Xóa điểm theo mã id\t\n" +
                "5.Thoát");
        System.out.print("Nhập lựa chọn: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addMark();
                break;
            case 2:
                showMark();
                break;
            case 3:
                updateMark();
                break;
            case 4:
                deleteMark();
                break;
            case 5:
                System.out.println("Quay trở lại!!");
                return;
            default:
                System.out.println("Yêu cầu nhập đúng trường từ 1 --> 5");
        }
    }

    public static int getIndexById(int id) {
        int check = -1;
        for (int i = 0; i < currentMark; i++) {
            if (marks[i].getMarkId() == id) {
                check = i;
            }
        }
        return check;
    }

    //Scanner sc, Student[] stdArr, int currentStd, Subject[] subjects, int currentSub, int idMark
    // addMark
    public static void addMark() {
        sc.nextLine();
        marks[currentMark] = new Mark();
        marks[currentMark].inputData(sc, StudentSevice.students, StudentSevice.currentStudent, SubjectSevice.subjects, SubjectSevice.currentSub, markId);
        currentMark++;
        markId++;
    }

    // deleteMark
    public static void deleteMark() {
        sc.nextLine();
        System.out.print("Nhập id điểm số: ");
        int idUpdate = sc.nextInt();
        int index = getIndexById(idUpdate);
        if (index != -1) {
            do {
                sc.nextLine();
                System.out.println("Bạn có chắc là muốn xóa điểm này? (y / n) ");
                marks[index].displayData();
                System.out.print("Nhập lựa chọn: ");
                String choice = sc.nextLine().toLowerCase();
                boolean isExit = true;
                switch (choice) {
                    case "y":
                        for (int i = index; i < currentMark; i++) {
                            marks[i] = marks[i + 1];
                        }
                        marks[currentMark] = null;
                        currentMark--;
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
            System.out.println("Không tồn tại điểm!!");
        }
    }

    // showMark
    public static void showMark() {
        System.out.println("DANH SÁCH ĐIỂM");
        if (marks[0] == null ){
            System.out.println("Không có điểm trong danh sách!!");
        } else {
            for (int i = 0; i < currentMark; i++) {
                marks[i].displayData();
            }
        }
    }

    // updateMark
    public static void updateMark() {
        sc.nextLine();
        System.out.print("Nhập id điểm số: ");
        int idUpdate = sc.nextInt();
        int index = getIndexById(idUpdate);
        if (index != -1) {
            do {
                sc.nextLine();
                System.out.println("Bạn có chắc là muốn cập nhập điểm học sinh này? (y / n) ");
                marks[index].displayData();
                System.out.print("Nhập lựa chọn: ");
                String choice = sc.nextLine().toLowerCase();
                boolean isExit = true;
                switch (choice) {
                    case "y":
                        System.out.print("Nhập số điểm muốn đổi: ");
                        marks[index].setPoint(sc.nextInt());
                        System.out.println("Sửa điểm thành công!!");
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
            System.out.println("Không tồn tại điểm!!");
        }
    }
}
