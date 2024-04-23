package one.hus.oop.datastructure;

public interface MyList {
    /**
     * Lấy kích thước mẫu.
     * @return kích thước mẫu.
     */
    int size();

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return giá trị phần tử ở vị trí index.
     */
    int get(int index);

    /**
     * Sửa dữ liệu ở vị trí index thành one.data.
     * @param data
     * @param index
     */
    void set(int data, int index);

    /**
     * Thêm dữ liệu vào đầu tập dữ liệu.
     * @param data
     */
    void insertAtStart(int data);

    /**
     * Thêm dữ liệu vào cuối tập dữ liệu.
     * @param data
     */
    void insertAtEnd(int data);

    /**
     * Thêm dữ liệu one.data vào vị trí index của tập dữ liệu.
     * @param data
     * @param index
     */
    void insertAtPos(int data, int index);

    /**
     * Xóa phần tử dũ liệu tại vị trí index.
     * @param index
     */
    void remove(int index);

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    int[] toArray();
}
