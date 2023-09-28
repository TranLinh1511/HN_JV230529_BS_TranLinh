package Exam_Advance;

import java.util.Scanner;

public class Subject {
    /**
     * subjectId – mã môn học – String(Gồm 5 kí tự bắt đầu bằng “MH” và 3 kí tự số bất kì , không trùng lặp )
     * subjectName – tên môn học – String (Không được để trống, không trùng nhau).
     */
    private String subjectId, subjectName;

    public void inputData(Scanner sc, Subject[] subArr, int currentSub) {
        sc.nextLine();
        System.out.println("<--------------------------------->");
        boolean isExit = true;
        do {
            System.out.print("Nhập mã môn học (Gồm 5 kí tự bắt đầu bằng “MH” và 3 kí tự số bất kì): ");
            this.subjectId = sc.nextLine();
            if (this.subjectId.matches("^MH\\d{3}$") || this.subjectId.matches("^mh\\d{3}$") ) {
                boolean isExist = false;
                for (int i = 0; i < currentSub; i++) {
                    if (subArr[i].subjectId.equals(this.subjectId)) {
                        isExist = true;
                    }
                }
                if (isExist) {
                    System.out.println("Mã môn học đã tồn tại!!");
                } else {
                    break;
                }
            } else {
                System.out.println("Mã môn học gồm 5 kí tự bắt đầu bằng “MH” và 3 kí tự số bất kì!!!");
            }
        } while (isExit);
        do {
            System.out.print("Nhập tên môn học: ");
            this.subjectName = sc.nextLine();
            if (this.subjectName.isEmpty()) {
                System.out.println("Tên môn học không được để trống!! ");
            } else {
                boolean isExist = false;
                for (int i = 0; i < currentSub; i++) {
                    if (subArr[i].subjectName.equals(this.subjectName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.out.println("Tên môn học đã tồn tại!!!");
                } else {
                    break;
                }
            }
        } while (isExit);
    }
    public void updateData(Scanner sc, Subject[] subArr, int currentSub) {
        sc.nextLine();
        System.out.println("<--------------------------------->");
        boolean isExit = true;
        do {
            System.out.print("Nhập tên môn học: ");
            this.subjectName = sc.nextLine();
            if (this.subjectName.isEmpty()) {
                System.out.println("Tên môn học không được để trống!! ");
            } else {
                boolean isExist = false;
                for (int i = 0; i < currentSub; i++) {
                    if (subArr[i].subjectName.equals(this.subjectName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.out.println("Tên môn học đã tồn tại!!!");
                } else {
                    break;
                }
            }
        } while (isExit);
    }
    public void  displayData() {
        System.out.println("Mã môn học: " + subjectId);
        System.out.println("Tên môn học: " + subjectName);
        System.out.println("<---------------------------------->");
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
