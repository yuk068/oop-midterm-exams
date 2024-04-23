package two.hus.oop.polynomial;

import java.util.stream.IntStream;

public class TestPolynomial {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_MyPolynomial>.txt
           (ví dụ, NguyenVanA_123456_MyPolynomial.txt)
         - Nộp kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testArrayPolynomial();
        testListPolynomial();
        testRootSolver();
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        System.out.println("ArrayPolynomial Test:");
        ArrayPolynomial arrayPoly = new ArrayPolynomial();
        IntStream.rangeClosed(1, 4).forEach(arrayPoly::insertAtEnd);
        System.out.println("f(x) = " + arrayPoly);
        arrayPoly.set(2, 6);
        System.out.println("Setting index 2 to 6.0: " + arrayPoly);
        ArrayPolynomial anotherArrayPoly = new ArrayPolynomial();
        IntStream.rangeClosed(3, 5).forEach(anotherArrayPoly::insertAtEnd);
        System.out.println("g(x): " + anotherArrayPoly);
        System.out.println("f(x) + g(x) = " + arrayPoly.plus(anotherArrayPoly));
        System.out.println("f(x) - g(x) = " + arrayPoly.minus(anotherArrayPoly));
        System.out.println("f(x) * g(x) =  " + arrayPoly.multiply(anotherArrayPoly));
        System.out.println("g(4) = " + anotherArrayPoly.evaluate(4));
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        System.out.println("ListPolynomial Test:");
        ListPolynomial listPoly = new ListPolynomial();
        IntStream.rangeClosed(1, 4).forEach(listPoly::insertAtEnd);
        System.out.println("f(x) = " + listPoly);
        listPoly.set(2, 6);
        System.out.println("Setting index 2 to 6.0: " + listPoly);
        ListPolynomial anotherListPoly = new ListPolynomial();
        IntStream.rangeClosed(3, 5).forEach(anotherListPoly::insertAtEnd);
        System.out.println("g(x): " + anotherListPoly);
        System.out.println("f(x) + g(x) = " + listPoly.plus(anotherListPoly));
        System.out.println("f(x) - g(x) = " + listPoly.minus(anotherListPoly));
        System.out.println("f(x) * g(x) =  " + listPoly.multiply(anotherListPoly));
        System.out.println("g(4) = " + anotherListPoly.evaluate(4));
    }

    public static void testRootSolver() {
        /*
         TODO

         - Tạo đa thức có nghiệm trong khoảng [a, b] nào đó.
         - Viết chương trình tìm nghiệm của đa thức theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           PolynomialRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, đa thức, và nghiệm của đa thức.
         */
        System.out.println("RootSolver Test:");
        Polynomial examplePoly = new ArrayPolynomial();
        examplePoly.insertAtEnd(2);
        examplePoly.insertAtEnd(0);
        examplePoly.insertAtEnd(-1);
        examplePoly.insertAtEnd(1);
        System.out.println("f(x) = " + examplePoly);
        PolynomialRootFinding solver = new PolynomialRootFinding(examplePoly);
        solver.setRootSolver(new BisectionSolver(0.00001f, 100000));
        System.out.println(String.format("%-20s", "Bisection:") + String.format("f(0) = %.6f", solver.solve(-200, 300)));
        solver.setRootSolver(new NewtonRaphsonSolver(0.00001f, 100000));
        System.out.println(String.format("%-20s", "NewtonRaphson:") + String.format("f(0) = %.6f", solver.solve(-200, 300)));
        solver.setRootSolver(new SecantSolver(0.00001f, 100000));
        System.out.println(String.format("%-20s", "Secant:") + String.format("f(0) = %.6f", solver.solve(-200, 300)));

    }
}
