package three.hus.oop.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }
                Student.StudentBuilder builder = new Student.StudentBuilder(dataList.get(0)).
                        withFirstname(dataList.get(2)).
                        withLastname(dataList.get(1)).
                        withYearOfBirth(Integer.parseInt(dataList.get(3))).
                        withMathsGrade(Double.parseDouble(dataList.get(4))).
                        withPhysicsGrade(Double.parseDouble(dataList.get(5))).
                        withChemistryGrade(Double.parseDouble(dataList.get(6)));
                StudentManager.getInstance().append(builder.build());
                /*
                TODO

                - Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào đối tượng được tạo ra từ
                lớp StudentManager để quản lý.
                - Đối tượng tạo ra từ lớp StudentManager là duy nhất trong chương trình, do dùng Singleton Pattern,
                và được tạo ra bằng cách gọi hàm StudentManager.getInstance().
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

    public static void main(String[] args) {
        init();
//        testOriginalData();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu và theo yêu cầu đã cho.
        - Viết code để test cho tất cả các hàm test.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
        // Test sorting methods
        testSortMathsGradeIncreasing();
        testSortMathsGradeDecreasing();
        testSortPhysicsGradeIncreasing();
        testSortPhysicsGradeDecreasing();
        testSortChemistryGradeIncreasing();
        testSortChemistryGradeDecreasing();
        testSortAverageGradeIncreasing();
        testSortAverageGradeDecreasing();

        // Test filtering methods
        testFilterStudentsHighestAverageGrade();
        testFilterStudentsLowestAverageGrade();
    }

    public static void init() {
        String filePath = "C:\\Users\\Phong Vu\\IdeaProjects\\midterm\\src\\three\\data\\students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortMathsGradeIncreasing() {
        List<Student> sorted = StudentManager.getInstance().sortMathsGradeIncreasing();
        System.out.println(sorted);
    }

    public static void testSortMathsGradeDecreasing() {
        List<Student> sorted = StudentManager.getInstance().sortMathsGradeDecreasing();
        System.out.println(sorted);
    }

    public static void testSortPhysicsGradeIncreasing() {
        List<Student> sorted = StudentManager.getInstance().sortPhysicsGradeIncreasing();
        System.out.println(sorted);
    }

    public static void testSortPhysicsGradeDecreasing() {
        List<Student> sorted = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        System.out.println(sorted);
    }

    public static void testSortChemistryGradeIncreasing() {
        List<Student> sorted = StudentManager.getInstance().sortChemistryGradeIncreasing();
        System.out.println(sorted);
    }

    public static void testSortChemistryGradeDecreasing() {
        List<Student> sorted = StudentManager.getInstance().sortChemistryGradeDecreasing();
        System.out.println(sorted);
    }

    public static void testSortAverageGradeIncreasing() {
        List<Student> sorted = StudentManager.getInstance().sortAverageGradeIncreasing();
        System.out.println(sorted);
    }

    public static void testSortAverageGradeDecreasing() {
        List<Student> sorted = StudentManager.getInstance().sortAverageGradeDecreasing();
        System.out.println(sorted);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        List<Student> filtered = StudentManager.getInstance().filterStudentsHighestAverageGrade(5);
        System.out.println(filtered);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        List<Student> filtered = StudentManager.getInstance().filterStudentsLowestAverageGrade(5);
        System.out.println(filtered);
    }
}
