package three.hus.oop.numbersystem;

import java.math.BigInteger;

public class BinaryConverter extends AbstractNumberConverter {
    public BinaryConverter(OriginalNumber originalNumber) {
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        BigInteger decimalValue = new BigInteger(decimal);
        StringBuilder result = new StringBuilder();

        if (decimalValue.equals(BigInteger.ZERO)) {
            return "0";
        }

        while (!decimalValue.equals(BigInteger.ZERO)) {
            BigInteger[] quotientAndRemainder = decimalValue.divideAndRemainder(BigInteger.valueOf(2));
            int remainder = quotientAndRemainder[1].intValue();
            char digit = (char) (remainder + '0');
            result.insert(0, digit);
            decimalValue = quotientAndRemainder[0];
        }

        return result.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(2).
     */
    @Override
    public void update() {
        originalNumber = new OriginalNumber(convertedNumber, 2);
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
        convert();
        System.out.println(convertedNumber);
    }
}
