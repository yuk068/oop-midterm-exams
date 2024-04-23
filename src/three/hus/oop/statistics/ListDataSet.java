package three.hus.oop.statistics;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListDataSet extends AbstractDataSet {
    private List<Double> data;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public ListDataSet() {
        data = new LinkedList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public double elementAt(int index) {
        checkBoundaries(index, size() - 1);
        return data.get(index);
    }

    @Override
    public double[] elements(int from, int to) {
        return data.subList(from, to + 1).stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param data giá trị của phần tử dữ liệu được thêm vào.
     */

    @Override
    public void insertAtStart(double data) {
        this.data.addFirst(data);
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param data giá trị của phần tử dữ liệu được thêm vào.
     */

    @Override
    public void insertAtEnd(double data) {
        this.data.addLast(data);
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * @param index
     * @param value
     */
    @Override
    public void insertAtPosition(int index, double value) {
        checkBoundaries(index, size());
        data.add(index, value);
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        checkBoundaries(index, size() - 1);
        data.remove(index);
    }

    /**
     * Xóa tất cả các phần tử dữ liệu có giá trị bằng value.
     * @param value
     */
    @Override
    public void remove(double value) {
        data.removeAll(Collections.singleton(value));
    }

}
