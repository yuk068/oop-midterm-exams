package two.hus.oop.polynomial;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double x0 = (lower + upper) / 2; // Initial guess

        for (int i = 0; i < maxIterations; i++) {
            double fx = polynomial.evaluate(x0); // Evaluate the function at x0
            double dfx = polynomial.derivative().evaluate(x0); // Evaluate the derivative at x0

            // Newton-Raphson iteration: x_(n+1) = x_n - f(x_n) / f'(x_n)
            double x1 = x0 - fx / dfx;

            // Check if the change in x is within tolerance
            if (Math.abs(x1 - x0) < tolerance) {
                return x1; // Return the root if tolerance is met
            }

            x0 = x1; // Update the guess for the next iteration
        }

        // Return NaN if maximum iterations reached without converging
        return Double.NaN;
    }
}
