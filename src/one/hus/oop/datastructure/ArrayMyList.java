package one.hus.oop.datastructure;

import java.util.Arrays;

public class ArrayMyList extends AbstractMyList {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayMyList() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy kích thước của tập dữ liệu.
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     *
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        checkBoundaries(index, size - 1);
        return data[index];
    }

    /**
     * Sửa dữ liệu ở vị trí index thành one.data.
     *
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        checkBoundaries(index, size - 1);
        this.data[index] = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     *
     * @param value là giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        insertAtPos(value, 0);
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     *
     * @param value là giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        insertAtPos(value, size);
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     *
     * @param value
     * @param index
     */
    @Override
    public void insertAtPos(int value, int index) {
        checkBoundaries(index, size);
        if (size >= data.length) allocateMore();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size - 1)]
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        checkBoundaries(index, size - 1);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void allocateMore() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     *
     * @return
     */
    @Override
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

}
