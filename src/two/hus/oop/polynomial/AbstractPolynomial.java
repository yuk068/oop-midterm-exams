package two.hus.oop.polynomial;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */

    public void checkBoundaries(int index, int limit) {
        if (index < 0 && index > limit) throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        StringBuilder polynomial = new StringBuilder();
        int power = 0;

        for (int i = 0; i < coefficients().length; i++) {
            polynomial.append(coefficientAt(i));
            if (power > 1) {
                polynomial.append("x^");
                polynomial.append(power);
            } else if (power == 1) {
                polynomial.append("x");
            }
            polynomial.append(i == coefficients().length - 1 ? "" : " + ");
            power++;
        }

        return polynomial.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
            if (degree() == 0) {
                return new double[]{0};
            }

            double[] derived = new double[degree()];
            for (int i = 1; i < degree() + 1; i++) {
                derived[i - 1] = coefficientAt(i) * i;
            }
            return derived;
    }
}
