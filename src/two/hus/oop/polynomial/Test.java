package two.hus.oop.polynomial;

public class Test {

    public static void main(String[] args) {
//        ArrayPolynomial apple = new ArrayPolynomial();
//        ArrayPolynomial banana = new ArrayPolynomial();
//        ListPolynomial apple = new ListPolynomial();
//        ListPolynomial banana = new ListPolynomial();
//        apple.insertAtEnd(3);
//        apple.insertAtEnd(2);
//        apple.insertAtEnd(4);
//
//        banana.insertAtEnd(1);
//        banana.insertAtEnd(2);
//        banana.insertAtEnd(3);
//        banana.insertAtEnd(4);
//        banana.insertAtEnd(5);
//
//        System.out.println(apple);
//        System.out.println(apple.evaluate(2));
//        System.out.println(banana);
//        System.out.println(banana.evaluate(3));
//        System.out.println(apple.plus(banana));
//        System.out.println(apple.minus(banana));
//        System.out.println(banana.minus(apple));
//
//        System.out.println(apple.multiply(banana));
//        System.out.println(banana.multiply(apple).derivative());

        Polynomial coconut = new ArrayPolynomial();
        coconut.insertAtEnd(2);
        coconut.insertAtEnd(0);
        coconut.insertAtEnd(-1);
        coconut.insertAtEnd(1);

        System.out.println(coconut);
        PolynomialRootFinding solver = new PolynomialRootFinding(coconut);
        solver.setRootSolver(new BisectionSolver(0.00001, 10000));
        System.out.println(solver.solve(-200, 300));
        solver.setRootSolver(new NewtonRaphsonSolver(0.00001, 10000));
        System.out.println(solver.solve(-200, 300));
        solver.setRootSolver(new SecantSolver(0.00001, 10000));
        System.out.println(solver.solve(-200, 300));
    }

}
