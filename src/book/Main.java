package book;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Bookmanage[] books = new Bookmanage[100];
    static int currentIndex = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách\n" +
                    "2. Hiển thị thông tin tất cả sách trong thư viện\n" +
                    "3. Sắp xếp sách theo lợi nhuận tăng dần\n" +
                    "4. Xóa sách theo mã sách\n" +
                    "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả\n" +
                    "6. Thay đổi thông tin sách theo mã sách\n" +
                    "7. Thoát\n");
            System.out.println("Nhập lựa chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    importBook();
                    break;
                case 2:
                    showBooks();
                    break;
                case 3:
                    sortByInterest();
                    break;
                case 4:
                    deleteById();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    updateById();
                    break;
                case 7:
                    System.out.println("Thoát chương trình!!");
                    break;
                default:
                    System.err.println("Yêu cầu nhập đúng trường từ 1 --> 7!!");
            }
        } while (true);
    }

    public static int getIndexById(int id) {
        sc.nextLine();
        int index = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (id == books[i].getBookId()) {
                index = i;
            }
        }
        return index;
    }

    // add
    public static void importBook() {
        System.out.println("Nhập số sách bạn muốn nhập: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            books[currentIndex] = new Bookmanage();
            System.out.println("Nhập thông tin sách thứ " + i);
            sc.nextLine();
            books[currentIndex].inputData(sc, currentIndex);
            currentIndex++;
        }
        System.out.println(currentIndex);
        System.out.println("Nhập thành công " + n + " sách.");
    }

    // show
    public static void showBooks() {
        if (currentIndex == 0) {
            System.err.println("Không có sách trong thư viện!!");
        } else {
            for (int i = 0; i < currentIndex; i++) {
                System.out.println("Thông tin sách thứ " + (i + 1));
                System.out.println("<-------------------------------------->");
                books[i].displayData();
                System.out.println("<-------------------------------------->");
            }
        }
    }

    // sort
    private static void sortByInterest() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < currentIndex - 1; i++) {
                if (books[i].getInterest() > books[i + 1].getInterest()) {
                    Bookmanage temp = books[i];
                    books[i] = books[i + 1];
                    books[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

        System.out.println("Sách sau khi sắp xếp theo lợi nhuận tăng dần:");
        for (int i = 0; i < currentIndex; i++) {
            books[i].displayData();
        }
    }

    // delete
    public static void deleteById() {
        System.out.print("Nhập id sách muốn xóa: ");
        int id = sc.nextInt();
        int index = getIndexById(id);
        if (index != -1) {
            do {
                System.out.println("Bạn có chắc là muốn xóa sách này? (y / n) ");
                System.out.println("<-------------------------------------->");
                books[index].displayData();
                System.out.println("<-------------------------------------->");
                System.out.print("Nhập lựa chọn: ");
                String choice = sc.nextLine().toLowerCase();
                boolean isExit = true;
                switch (choice) {
                    case "y":
                        for (int i = index; i < currentIndex; i++) {
                            books[i] = books[i + 1];
                        }
                        books[currentIndex] = null;
                        currentIndex--;
                        System.out.println("Đã xóa thành công!!");
                        break;
                    case "n":
                        isExit = false;
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
            System.out.println("Id sách không tồn tại!!");
        }
    }

    // search
    public static void searchBook() {
        sc.nextLine();
        System.out.println("Nhập tên sách hoặc mô tả sách bạn muốn tìm kiếm: ");
        String searchValue = sc.nextLine();
        System.out.println("Kết quả: ");
        boolean check = true;
        for (int i = 0; i < currentIndex; i++) {
            if (books[i].getBookName().equals(searchValue) || books[i].getDes().equals(searchValue)) {
                System.out.println("<------------------------------>");
                books[i].displayData();
                System.out.println("<------------------------------>");
                check = false;
            }
        }
        if (check) {
            System.err.println("Không tìm thấy sách!!!");
        }
    }

    // updateById
    public static void updateById() {
        System.out.println("Nhập id sách bạn muốn sửa: ");
        int id = sc.nextInt();
        int index = getIndexById(id);
        if (index == -1) {
            System.out.println("Id sách không tồn tại!!");
        } else {
            do {
                boolean check = true;
                System.out.println("Bạn có chắc chắn muốn cập nhật sách này? (y / n) ");
                System.out.println("<-------------------------------------->");
                books[index].displayData();
                System.out.println("<-------------------------------------->");
                System.out.print("Nhập lựa chọn: ");
                String choice = sc.nextLine().toLowerCase();
                switch (choice) {
                    case "y":
                        books[index].update(sc);
                        break;
                    case "n":
                        break;
                    default:
                        check = false;
                        System.err.println("Yêu cầu nhập đúng định dạng y / n");
                        break;
                }
                if (check) {
                    break;
                }
            } while (true);
        }

    }
}
