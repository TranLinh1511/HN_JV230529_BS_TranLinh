package Exam_Advance;

import java.util.Scanner;

public class SubjectSevice {
    static Subject[] subjects = new Subject[100];
    static int currentSub = 0;
    static Scanner sc = new Scanner(System.in);

    public static void subjectManagement() {
        do {
            System.out.println("  **********************SUBJECT-MANAGEMENT*************************\n" +
                    "1.Thêm mới môn học\t\t\t\t\t\t\t\t \n" +
                    "2.Hiển thị danh sách tất cả môn học đã lưu trữ\t\t\t\t   \n" +
                    "3.Thay đổi thông tin học môn học theo mã id\t\t\t\t\n" +
                    "4.Xóa môn học theo mã id\t\t\t\t\t\t\t\t\t\t\n" +
                    "5.Thoát\n");
            System.out.print("Nhập lựa chọn: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addSubject();
                    return;
                case 2:
                    showSubject();
                    return;
                case 3:
                    updateSubject();
                    return;
                case 4:
                    deleteSubject();
                    return;
                case 5:
                    System.out.println("Quay trở lại menu!!");
                    return;
                default:
                    System.out.println("Yêu cầu nhập đúng trường 1 --> 5");
            }
        } while (true);
    }

    public static int getIndexById(String id) {
        int check = -1;
        for (int i = 0; i < currentSub; i++) {
            if (subjects[i].getSubjectId().equals(id)) {
                check = i;
            }
        }
        return check;
    }

    public static void addSubject() {
        subjects[currentSub] = new Subject();
        subjects[currentSub].inputData(sc, subjects, currentSub);
        currentSub++;
        System.out.println("Thêm mới môn học thành công!!");
    }

    // show
    public static void showSubject() {
        System.out.println("DANH SÁCH MÔN HỌC");
        if (subjects[0] == null) {
            System.out.println("Không có môn học nào trong danh sách");
        } else {
            for (int i = 0; i < currentSub; i++) {
                subjects[i].displayData();
            }
        }
    }

    // UPDATE
    public static void updateSubject() {
        sc.nextLine();
        System.out.println("Nhập id môn học muốn đổi: ");
        String id = sc.nextLine();
        int index = getIndexById(id);
        if (index != -1) {
            do {
                System.out.println("Bạn có chắc là muốn cập nhập môn học này? (y / n) ");
                subjects[index].displayData();
                System.out.print("Nhập lựa chọn: ");
                String choice = sc.nextLine().toLowerCase();
                boolean isExit = true;
                switch (choice) {
                    case "y":
                        subjects[index].updateData(sc, subjects, currentSub);
                        System.out.println("Sửa tên môn học thành công!!");
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
            System.out.println("Không tồn tại môn học!!");
        }
    }

    // DELETE
    public static void deleteSubject() {
        sc.nextLine();
        System.out.print("Nhập id môn học: ");
        String idUpdate = sc.nextLine();
        int index = getIndexById(idUpdate);
        if (index != -1) {
            do {
                System.out.println("Bạn có chắc là muốn xóa môn học này? (y / n) ");
                subjects[index].displayData();
                System.out.print("Nhập lựa chọn: ");
                String choice = sc.nextLine().toLowerCase();
                boolean isExit = true;
                switch (choice) {
                    case "y":
                        for (int i = index; i < currentSub; i++) {
                            subjects[i] = subjects[i + 1];
                        }
                        subjects[currentSub] = null;
                        currentSub--;
                        System.out.println("Đã xóa môn học thành công!!");
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
