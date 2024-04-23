package two.hus.oop.bookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        init();
//        testOriginalData();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_BookManager>.txt (Ví dụ, NguyenVanA_123456_BookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookManager>.zip (Ví dụ, NguyenVanA_123456_BookManager.zip),
          nộp lên classroom.
         */
        testFilterBooksHighestPrice();
        testFilterBooksLowestPrice();
        testFilterBooksOfAuthor();
        testFilterBooksOfGenre();
        testFilterBooksOfPublisher();
        testPriceOfBooksDecreasing();
        testPriceOfBooksIncreasing();
        testSortDecreasingTitleAndPrice();
        testSortIncreasingTitleAndPrice();
    }

    public static void init() {
        String filePath = "C:\\Users\\Phong Vu\\IdeaProjects\\2024\\src\\practice\\midtermtest\\two\\books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }
                if (dataList.get(0).equals("title")) {
                    continue;
                }
                Book.BookBuilder book = new Book.BookBuilder(dataList.get(0)).
                        withAuthor(dataList.get(1)).
                        withGenre(dataList.get(2)).
                        withPages(Integer.parseInt(dataList.get(3))).
                        withPrice(Double.parseDouble(dataList.get(4))).
                        withPublisher(dataList.get(5));
                bookManager.insertAtEnd(book.build());
                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào bookManager để quản lý.

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        List<Book> books = bookManager.getBookList();
        System.out.print(books);
    }

    /**
     * Test sắp xếp book theo tiêu chí, đầu tiên theo title tăng dần, sau đó theo giá giảm dần.
     */
    public static void testSortIncreasingTitleAndPrice() {
        List<Book> toSort = bookManager.sortIncreasingTitleAndPrice();
        System.out.println(toSort);
    }

    /**
     * Test sắp xếp book theo tiêu chí, đầu tiên theo title giảm dần, sau đó theo giá giảm dần.
     */
    public static void testSortDecreasingTitleAndPrice() {
        List<Book> toSort = bookManager.sortDecreasingTitleAndPrice();
        System.out.println(toSort);
    }

    /**
     * Test sắp xếp book theo giá tăng dần.
     */
    public static void testPriceOfBooksIncreasing() {
        List<Book> toSort = bookManager.sortIncreasingPrice();
        System.out.println(toSort);
    }

    /**
     * Test sắp xếp book theo giá giảm dần
     */
    public static void testPriceOfBooksDecreasing() {
        List<Book> toSort = bookManager.sortDecreasingPrice();
        System.out.println(toSort);
    }

    /**
     * Test lọc ra những book có giá rẻ nhất.
     */
    public static void testFilterBooksLowestPrice() {
        List<Book> toFilter = bookManager.filterLowestPrice(5);
        System.out.println(toFilter);
    }

    /**
     * Test lọc ra những book có giá cao nhất.
     */
    public static void testFilterBooksHighestPrice() {
        List<Book> toFilter = bookManager.filterHighestPrice(5);
        System.out.println(toFilter);
    }

    /**
     * Test lọc ra những book theo tác giả.
     */
    public static void testFilterBooksOfAuthor() {
        List<Book> toFilter = bookManager.filterBooksOfAuthor("Smith Adam");
        System.out.println(toFilter);
    }

    /**
     * Test lọc ra những book theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher() {
        List<Book> toFilter = bookManager.filterBooksOfPublisher("Dell");
        System.out.println(toFilter);
    }

    /**
     * Test lọc ra những book theo thể loại.
     */
    public static void testFilterBooksOfGenre() {
        List<Book> toFilter = bookManager.filterBooksOfGenre("computer_science");
        System.out.println(toFilter);
    }
}
