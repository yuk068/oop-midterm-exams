package two.hus.oop.polynomial;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;

        for (int i = 0; i < maxIterations; i++) {
            double fx0 = polynomial.evaluate(x0);
            double fx1 = polynomial.evaluate(x1);
            double x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);

            // Check if the change in x is within tolerance
            if (Math.abs(x2 - x1) < tolerance) {
                return x2; // Return the root if tolerance is met
            }

            x0 = x1;
            x1 = x2;
        }

        // Return NaN if maximum iterations reached without converging
        return Double.NaN;
    }
}
