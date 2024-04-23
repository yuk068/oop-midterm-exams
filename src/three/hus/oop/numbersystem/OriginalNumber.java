package three.hus.oop.numbersystem;

import java.util.LinkedList;
import java.util.List;

public class OriginalNumber {
    private String numberPresentation;  // Biểu diễn số ban đầu
    private int radix;                  // Cơ số của số ban đầu
    private List<NumberConverter> converters;  // Danh sách các converter theo observer pattern

    public OriginalNumber(String originalNumber, int radix) {
        this.numberPresentation = originalNumber;
        this.radix = radix;
        converters = new LinkedList<>();
    }

    /**
     * Thêm vào converter để quan sát số ban đầu.
     * @param converter
     */
    public void addConverter(NumberConverter converter) {
        converters.add(converter);
    }

    /**
     * Hủy quan sát số ban đầu của converter.
     * @param converter
     */
    public void removeConverter(NumberConverter converter) {
        converters.remove(converter);
    }

    /**
     * Khi có sự thay đổi trạng thái (biểu diễn số hoặc cơ số), thông báo cho tất cả
     * các converter đang ký quan sát để cập nhật lại trạng thái theo dữ liệu mới.
     */
    public void notifyConverters() {
        onStateChanged();
    }

    public String getNumberPresentation() {
        return numberPresentation;
    }

    public void setNumberPresentation(String numberPresentation) {
        this.numberPresentation = numberPresentation;
    }

    public int getRadix() {
        return radix;
    }

    public void setRadix(int radix) {
        this.radix = radix;
    }

    /**
     * Được gọi khi có sự thay đổi về trạng thái (biểu diến số hoặc cơ số),
     * hàm này sẽ gọi hàm để thông báo cho tất cả các observer đang ký quan sát
     * cập nhật lại trạng thái.
     */
    private void onStateChanged() {
        converters.forEach(NumberConverter::update);
    }
}