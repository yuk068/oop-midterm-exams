package three.hus.oop.statistics;

import java.util.Arrays;
import java.util.Random;

public class TestStatistics {
    public static void main(String[] args) {
        /* TODO

         - Viết các hàm test như yêu cầu và chạy test chương trình.
         - Copy kết quả chạy chương trình và lưu vào file text có tên <Ten_MaSinhVien_Statistics>.txt
         (ví dụ, NguyenVanA_123456S_Statistics.txt).
          - Nén các file source code và file text kết quả chạy chương trình theo định dạng .zip,
         đặt tên là <Ten_MaSinhVien_Statistics>.zip (ví dụ, NguyenVanA_123456_Statistics.zip) và nộp lên classroom.
         */
        testArrayDataSet();
        testListDataSet();
    }

    public static void testArrayDataSet() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên trong đoạn [10, 20], gọi là n.
         - Sinh ra n số thực kiểu double ngẫu nhiên, cho vào tập dữ liệu
         - In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         - Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu.
         In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         */
        System.out.println("ArrayDataSet Test:");
        Random random = new Random();
        DataSet dataSet = new ArrayDataSet();
        int size = random.nextInt(11) + 10;
        for (int i = 0; i < size; i++) {
            dataSet.insertAtEnd(random.nextDouble(30));
        }
        System.out.println(dataSet);
        BasicStatistic operator = BasicStatistic.getInstance(dataSet);
        System.out.println("Max: " + operator.max());
        System.out.println("Min: " + operator.min());
        System.out.println("Mean: " + operator.mean());
        System.out.println("Median: " + operator.median());
        System.out.println("Variance: " + operator.variance());
        System.out.println("Rank: " + Arrays.toString(operator.rank()));
    }

    public static void testListDataSet() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên trong đoạn [10, 20], gọi là n.
         - Sinh ra n số thực kiểu double ngẫu nhiên, cho vào tập dữ liệu
         - In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         - Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu.
         In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         */
        System.out.println("ListDataSet Test:");
        Random random = new Random();
        DataSet dataSet = new ListDataSet();
        int size = random.nextInt(11) + 10;
        for (int i = 0; i < size; i++) {
            dataSet.insertAtEnd(random.nextDouble(30));
        }
        System.out.println(dataSet);
        BasicStatistic operator = BasicStatistic.getInstance(dataSet);
        System.out.println("Max: " + operator.max());
        System.out.println("Min: " + operator.min());
        System.out.println("Mean: " + operator.mean());
        System.out.println("Median: " + operator.median());
        System.out.println("Variance: " + operator.variance());
        System.out.println("Rank: " + Arrays.toString(operator.rank()));
    }
}
