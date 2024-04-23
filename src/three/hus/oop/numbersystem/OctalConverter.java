package three.hus.oop.numbersystem;

public class OctalConverter extends AbstractNumberConverter {
    public OctalConverter(OriginalNumber originalNumber) {
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     *
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
     * <p>
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        int decimalValue = Integer.parseInt(decimal);
        StringBuilder result = new StringBuilder();
        if (decimalValue == 0) {
            return "0";
        }
        while (decimalValue > 0) {
            int remainder = decimalValue % 8;
            char digit = (char) (remainder + '0');
            result.insert(0, digit);
            decimalValue /= 8;
        }

        return result.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(8).
     */
    @Override
    public void update() {
        originalNumber = new OriginalNumber(convertedNumber, 8);
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(8).
     */
    @Override
    public void display() {
        convert();
        System.out.println(convertedNumber);
    }
}
