package two.hus.oop.polynomial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficientAt(int index) {
        checkBoundaries(index, size - 1);
        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        return Arrays.copyOf(coefficents, size);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtStart(double coefficient) {
        insertAtPosition(0, coefficient);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtEnd(double coefficient) {
        insertAtPosition(size, coefficient);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void insertAtPosition(int index, double coefficient) {
        checkBoundaries(index, size);
        if (size >= coefficients().length) allocateMore();
        System.arraycopy(coefficents, index, coefficents, index + 1, size - index);
        coefficents[index] = coefficient;
        size++;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void set(int index, double coefficient) {
        checkBoundaries(index, size - 1);
        coefficents[index] = coefficient;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        return size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        double evaluation = coefficents[0];
        for (int i = 1; i < size; i++) {
            evaluation += Math.pow(x, i) * coefficents[i];
        }

        return evaluation;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        List<Double> derivatives = Arrays.stream(differentiate())
                .boxed()
                .toList();
        Polynomial derived = new ArrayPolynomial();
        derivatives.forEach(derived::insertAtEnd);
        return derived;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ArrayPolynomial result = new ArrayPolynomial();

        for (int i = 0; i <= operationalDegree; i++) {
            result.insertAtEnd(coefficientAt(i) + another.coefficientAt(i));
        }
        IntStream.rangeClosed(operationalDegree + 1, maxDegree)
                .mapToDouble(i -> degree() > another.degree() ? coefficientAt(i) : another.coefficientAt(i))
                .forEach(result::insertAtEnd);

        return result;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ArrayPolynomial result = new ArrayPolynomial();

        for (int i = 0; i <= operationalDegree; i++) {
            result.insertAtEnd(coefficientAt(i) - another.coefficientAt(i));
        }
        IntStream.rangeClosed(operationalDegree + 1, maxDegree)
                .mapToDouble(i -> degree() > another.degree() ? coefficientAt(i) : -another.coefficientAt(i))
                .forEach(result::insertAtEnd);

        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        int maxDegree = degree() + another.degree();
        ArrayPolynomial result = new ArrayPolynomial();

        IntStream.range(0, maxDegree + 1)
                .forEach(i -> result.insertAtEnd(0));

        for (int i = 0; i <= degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                int termDegree = i + j;
                double termCoefficient = coefficientAt(i) * another.coefficientAt(j);
                result.set(termDegree, result.coefficientAt(termDegree) + termCoefficient);
            }
        }

        return result;
    }

    /**
     * Thêm kích thước mảng gấp đôi để lưu đa thức.
     */
    private void allocateMore() {
        double[] newCoeffs = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newCoeffs, 0, size);
        coefficents = newCoeffs;
    }

}
