package two.hus.oop.polynomial;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        coefficients = new LinkedList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     *
     * @return
     */
    @Override
    public double coefficientAt(int index) {
        checkBoundaries(index, coefficients.size() - 1);
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     *
     * @return mảng các hệ số của đa thức
     */
    @Override
    public double[] coefficients() {
        return coefficients.stream().mapToDouble(Double::doubleValue).toArray();
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtStart(double coefficient) {
        coefficients.addFirst(coefficient);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtEnd(double coefficient) {
        coefficients.addLast(coefficient);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void insertAtPosition(int index, double coefficient) {
        checkBoundaries(index, coefficients.size());
        coefficients.add(index, coefficient);
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void set(int index, double coefficient) {
        checkBoundaries(index, coefficients.size() - 1);
        coefficients.set(index, coefficient);
    }

    /**
     * Lấy ra bậc của đa thức.
     *
     * @return
     */
    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return
     */
    @Override
    public double evaluate(double x) {
        return IntStream.range(0, degree() + 1)
                .mapToDouble(i -> coefficients.get(i) * Math.pow(x, i))
                .sum();
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
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
     * Cộng đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ListPolynomial result = new ListPolynomial();

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
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ListPolynomial result = new ListPolynomial();

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
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        int maxDegree = degree() + another.degree();
        ListPolynomial result = new ListPolynomial();

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
}
