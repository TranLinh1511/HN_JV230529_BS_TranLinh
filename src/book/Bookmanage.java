package book;

import java.util.Scanner;

public class Bookmanage {
    private String bookName, author, des;
    private int bookId;
    private double importPrice, exportPrice;
    private float interest;
    boolean bookStatus;

    public String getBookName() {
        return bookName;
    }

    public Bookmanage() {
    }

    ;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getBookId() {
        return bookId;
    }

    public  void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Bookmanage(String bookName) {
        this.bookName = bookName;
    }

    public void inputData(Scanner sc, int id) {
        System.out.println("<-------------------------------------->");
        boolean isExit = true;
        do {
            System.out.println("Nhập tên sách: ");
            this.bookName = sc.nextLine();
            if (this.bookName.isEmpty()) {
                System.out.println("Tên sách không được bỏ trống!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập tác giả: ");
            this.author = sc.nextLine();
            if (this.bookName.isEmpty()) {
                System.out.println("Tên tác giả không được bỏ trống!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập mô tả sách: ");
            this.des = sc.nextLine();
            if (this.des.isEmpty()) {
                System.out.println("Mô tả sách không được bỏ trống!!");
            } else if (des.length() <= 10) {
                System.out.println("Mô tả phải nhiều hơn hoặc bằng 10 kí tự");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Giá nhập sách: ");
            this.importPrice = sc.nextFloat();
            if (this.importPrice < 0) {
                System.out.println("Giá nhập vào không được nhỏ hơn 0!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            sc.nextLine();
            System.out.println("Giá xuất sách: ");
            this.exportPrice = sc.nextFloat();
            if (this.exportPrice < this.importPrice * 1.2) {
                System.out.println("Giá xuất sách phải lớn hơn 1.2 lần giá nhập!!");
            } else {
                break;
            }
        } while (isExit);
        this.bookStatus = true;
        this.interest = (float) (this.exportPrice - this.importPrice);
        this.bookId = id;
    }

    public void update(Scanner sc) {
        System.out.println("<-------------------------------------->");
        boolean isExit = true;
        do {
            System.out.println("Nhập tên sách: ");
            this.bookName = sc.nextLine();
            if (this.bookName.isEmpty()) {
                System.out.println("Tên sách không được bỏ trống!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập tác giả: ");
            this.author = sc.nextLine();
            if (this.bookName.isEmpty()) {
                System.out.println("Tên tác giả không được bỏ trống!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Nhập mô tả sách: ");
            this.des = sc.nextLine();
            if (this.des.isEmpty()) {
                System.out.println("Mô tả sách không được bỏ trống!!");
            } else if (des.length() <= 10) {
                System.out.println("Mô tả phải nhiều hơn hoặc bằng 10 kí tự");
            } else {
                break;
            }
        } while (isExit);
        do {
            System.out.println("Giá nhập sách: ");
            this.importPrice = sc.nextFloat();
            if (this.importPrice < 0) {
                System.out.println("Giá nhập vào không được nhỏ hơn 0!!");
            } else {
                break;
            }
        } while (isExit);
        do {
            sc.nextLine();
            System.out.println("Giá xuất sách: ");
            this.exportPrice = sc.nextFloat();
            if (this.exportPrice < this.importPrice * 1.2) {
                System.out.println("Giá xuất sách phải lớn hơn 1.2 lần giá nhập!!");
            } else {
                break;
            }
        } while (isExit);
        this.bookStatus = true;
        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + this.bookName);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Mô tả: " + this.des);
        System.out.println("Giá nhập vào: " + this.importPrice + " VND");
        System.out.println("Giá xuất ra: " + this.exportPrice + " VND");
        System.out.println("Lợi nhuận: " + this.interest + "VND");
        System.out.println("Trạng thái: " + (this.bookStatus ? "Đang được bán" : "Không được bán"));
    }
}
