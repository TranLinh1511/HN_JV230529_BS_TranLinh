package Exam_Advance;

import java.util.Date;
import java.util.Scanner;

public class Student {
    /**
     * studentId – mã học sinh – int (Tự động tăng)
     * studentName – tên học sinh – String (Không được để trống)
     * birthDay – ngày sinh – Date
     * address – địa chỉ – String (không được để trống)
     * gender - giới tính - boolean
     * phone - số điện thoại - String (10 hoặc 11 số , bắt đầu bằng số 0, không trùng lặp)
     */
    private String studentName, address, phone, birthDay;
    private int studentId;
    private boolean gender;

    // input data
    public void inputData(Scanner sc, Student [ ] stdArr, int currentIndex, int idStudent) {
        sc.nextLine();
        System.out.println("<-------------------------------->");
        boolean isExit = true;
        this.studentId = idStudent;
        do {
            System.out.println("Nhập tên học sinh: ");
            this.studentName = sc.nextLine();
            if (this.studentName.isEmpty()) {
                System.out.println("Tên học sinh không được để trống!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập ngày sinh học sinh: (dd/MM/yyyy) ");
            this.birthDay = sc.nextLine();
            if (this.birthDay.isEmpty()) {
                System.out.println("Tên học sinh không được để trống!!");
            } else if (!this.birthDay.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
                System.out.println("Nhập không đúng định dạng dd/MM/yyyy!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập địa chỉ học sinh: ");
            this.address = sc.nextLine();
            if (this.studentName.isEmpty()) {
                System.out.println("Địa chỉ học sinh không được để trống!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập giới tính học sinh: (Nam / Nữ) ");
            String str = sc.nextLine().toLowerCase();
            if (str.isEmpty()) {
                System.out.println("Địa chỉ học sinh không được để trống!!");
            } else {
                boolean check = true;
                switch (str) {
                    case "nam":
                        this.gender = true;
                        break;
                    case "nữ":
                        this.gender = false;
                        break;
                    default:
                        check = false;
                        System.out.println("Yêu cầu nhập đúng trường Nam / Nữ");
                        break;
                }
                if (check) {
                    break;
                }
            }
        } while (isExit);
        do {
            System.out.println("Nhập số điện thoại học sinh: ");
            this.phone = sc.nextLine();
            if (this.phone.startsWith("0")) {
                if (this.phone.length() >= 10 && this.phone.length() <= 11) {
                    boolean isExist = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (this.phone.equals(stdArr[i].phone)) {
                            isExist = true;
                            break;
                        }
                    }
                    if(isExist) {
                        System.out.println("Số điện thoại đã tồn tại!!");
                    }  else {
                        break;
                    }
                } else {
                    System.out.println("Độ dài số điện thoại phải nằm trong khoảng từ 10 -> 11!!");
                }
            } else {
                System.out.println("Số điện thoại phải bắt đầu từ số 0!!!");
            }
        } while (isExit);
    }
    public void updateData(Scanner sc, Student [ ] stdArr, int currentIndex, int idStudent) {
        sc.nextLine();
        System.out.println("<-------------------------------->");
        boolean isExit = true;
        this.studentId = idStudent;
        do {
            System.out.println("Nhập tên học sinh: ");
            this.studentName = sc.nextLine();
            if (this.studentName.isEmpty()) {
                System.out.println("Tên học sinh không được để trống!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập ngày sinh học sinh: (dd/MM/yyyy) ");
            this.birthDay = sc.nextLine();
            if (this.birthDay.isEmpty()) {
                System.out.println("Tên học sinh không được để trống!!");
            } else if (!this.birthDay.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
                System.out.println("Nhập không đúng định dạng dd/MM/yyyy!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập địa chỉ học sinh: ");
            this.address = sc.nextLine();
            if (this.studentName.isEmpty()) {
                System.out.println("Địa chỉ học sinh không được để trống!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập giới tính học sinh: (Nam / Nữ) ");
            String str = sc.nextLine().toLowerCase();
            if (str.isEmpty()) {
                System.out.println("Địa chỉ học sinh không được để trống!!");
            } else {
                boolean check = true;
                switch (str) {
                    case "nam":
                        this.gender = true;
                        break;
                    case "nữ":
                        this.gender = false;
                        break;
                    default:
                        check = false;
                        System.out.println("Yêu cầu nhập đúng trường Nam / Nữ");
                        break;
                }
                if (check) {
                    break;
                }
            }
        } while (isExit);
        do {
            System.out.println("Nhập số điện thoại học sinh: ");
            this.phone = sc.nextLine();
            if (this.phone.startsWith("0")) {
                if (this.phone.length() >= 10 && this.phone.length() <= 11) {
                    boolean isExist = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (stdArr[i].phone.equals(this.phone)) {
                            isExist = true;
                            break;
                        }
                    }
                    if(isExist) {
                        break;
                    }
                } else {
                    System.out.println("Độ dài số điện thoại phải nằm trong khoảng từ 10 -> 11!!");
                }
            } else {
                System.out.println("Số điện thoại phải bắt đầu từ số 0!!!");
            }
        } while (isExit);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void displayData() {
        System.out.println("Mã học sinh: " + studentId);
        System.out.println("Tên học sinh: " + studentName);
        System.out.println("Địa chỉ học sinh: " + address);
        System.out.println("Ngày sinh: " + birthDay);
        System.out.println("Giới tính học sinh: "+ (gender? "Nam" : "Nữ"));
        System.out.println("Số điện thoại học sinh: " + phone);
        System.out.println("<---------------------------------->");
    }

}
