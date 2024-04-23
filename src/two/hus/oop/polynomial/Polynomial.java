package two.hus.oop.polynomial;

public interface Polynomial {
    /**
     * Lấy ra hệ số của đa thức tại phần tử index.
     * @return hệ số của đa thức tại phần tử index.
     */
    double coefficientAt(int index);

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    double[] coefficients();

    /**
     * Thêm phần tử vào đầu đa thức.
     * @param coefficient
     */
    void insertAtStart(double coefficient);

    /**
     * Thêm phần tử vào cuối đa thức.
     * @param coefficient
     */
    void insertAtEnd(double coefficient);

    /**
     * Thêm phần tử vào vị trí index.
     * @param coefficient
     */
    void insertAtPosition(int index, double coefficient);

    /**
     * Sửa hệ số của đa thức ở vị trí index thành coefficient
     * @param index
     * @param coefficient
     */
    void set(int index, double coefficient);

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    int degree();

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    double evaluate(double x);

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức là đa thức đạo hàm của đa thức ban đầu.
     */
    Polynomial derivative();
}
