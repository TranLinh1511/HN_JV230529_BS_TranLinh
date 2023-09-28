package Exam_Advance;

import java.util.Scanner;

public class SchoolManagement {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************\n" +
                    "1. Quản lý học sinh\n" +
                    "2. Quản lý môn học\n" +
                    "3. Quản lí điểm thi\n" +
                    "4. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    StudentSevice.studentManagement();
                    break;
                case 2:
                    SubjectSevice.subjectManagement();
                    break;
                case 3:
                    MarkService.markManagement();
                    break;
                case 4:
                    System.out.println("Thoát chương trình!!");
                    sc.close();
                    break;
                default:
                    System.out.println("Yêu cầu nhập đúng trường 1 -> 4!!");
            }
        } while (true);

    }


    public static void subjectManagement() {
    }

    public static void markManagement() {
    }
}
