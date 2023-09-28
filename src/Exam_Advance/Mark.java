package Exam_Advance;

import java.util.Scanner;

public class Mark {
    /**
     * markId – mã điểm  – int (tự tăng)
     * student –  sinh viên  – Student(Không được null)
     * subject - môn học - Subject(không được null)
     * point - double - (từ 0 đến 10)
     */
    private int markId;
    private Student student;
    private Subject subject;
    private double point;

    public Mark() {
    }

    ;

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    /**
     * Triển khai phương thức inputData():
     * Thực hiện thị danh sách học sinh và môn học cho người dùng chọn theo id nhập vào,
     * nếu không có học sinh hoặc môn học thì bắt buộc người dùng thêm học sinh và môn học trước.
     * Nhập thông tin điểm số từ bàn phím
     */
    public void inputData(Scanner sc, Student[] stdArr, int currentStd, Subject[] subjects, int currentSub, int idMark) {
        System.out.println("<---------------------------------->");
        this.markId = idMark;
        boolean isExit = true;
        do {
            System.out.println("DANH SÁCH HỌC SINH: ");
            if (stdArr[0] == null) {
                System.out.println("Không có học sinh nào trong danh sách, yêu cầu thêm học sinh!!");
                break;
            } else {
                for (int i = 0; i < currentStd; i++) {
                    stdArr[i].displayData();
                }
            }
            System.out.println("DANH SÁCH MÔN HỌC:");
            if (subjects[0] == null) {
                System.out.println("Không có môn học nào trong danh sách, yêu cầu thêm môn học!!");
                break;
            } else {
                for (int i = 0; i < currentSub; i++) {
                    subjects[i].displayData();
                }
            }
            do {
                System.out.print("Nhập id học sinh: ");
                int idStudent = sc.nextInt();
                int checkStd = -1;
                for (int i = 0; i < currentStd; i++) {
                    if (stdArr[i].getStudentId() == idStudent) {
                        checkStd = i;
                        break;
                    }
                }
                if (checkStd == -1) {
                    System.out.println("Id học sinh không tồn tại!!");
                } else {
                    this.student = stdArr[checkStd];
                    break;
                }

            } while (isExit);
            do {
                sc.nextLine();
                System.out.print("Chọn id môn học: ");
                String idSubject = sc.nextLine();
                int checkSub = -1;
                for (int i = 0; i < currentSub; i++) {
                    if (subjects[i].getSubjectId().equals(idSubject)) {
                        checkSub = i;
                        break;
                    }
                }
                if (checkSub == -1) {
                    System.out.println("Mã môn học không tồn tại");
                } else {
                    this.subject = subjects[checkSub];
                    break;
                }
            } while (isExit);
            boolean exit = true;
            do {
                System.out.println("Nhập số điểm: ");
                this.point = sc.nextFloat();
                if (this.point >= 0 && this.point <= 10) {
                    break;
                } else {
                    System.out.println("Điểm số phải nằm trong khoảng từ 0 --> 10");
                    exit = false;
                }
            }while (isExit);
            if(exit){
                System.out.println("Thêm điểm thành công!!");
                break;
            }
        } while (isExit);
    }

    // display
    public void displayData() {
        System.out.println("Mã điểm: " + markId);
        System.out.println("Tên học sinh: " + student.getStudentName());
        System.out.println("Tên môn học: " + subject.getSubjectName());
        System.out.println("Số điểm: " + point);
        System.out.println("<--------------------------->");
    }
}
