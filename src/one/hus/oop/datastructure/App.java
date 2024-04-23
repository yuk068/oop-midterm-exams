package one.hus.oop.datastructure;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        /*
        Yêu cầu:

        - Hoàn thiện code chương trình theo mẫu đã cho.

        - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [15 - 30], gọi là n.
        - Sinh ra n số nguyên ngẫu nhiên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.

        - Sinh ra n số nguyên ngẫu nhiên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
        */
        testStack();
        testQueue();
    }

    public static void testStack() {
        MyStack stack = new MyStack();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            stack.push(random.nextInt(16) + 15);
        }
        System.out.println(stack.getStackData());
        System.out.println(stack.isEmpty());
        for (int i = 0; i < 10; i++) {
            System.out.println((stack.pop()));
            System.out.println(stack.getStackData());
        }
        System.out.println(stack.getStackData());
        System.out.println(stack.isEmpty());
    }

    public static void testQueue() {
        MyQueue queue = new MyQueue();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            queue.add(random.nextInt(11) + 10);
        }
        System.out.println(queue.getQueueData());
        System.out.println(queue.isEmpty());
        for (int i = 0; i < 10; i++) {
            System.out.println((queue.remove()));
            System.out.println(queue.getQueueData());
        }
        System.out.println(queue.getQueueData());
        System.out.println(queue.isEmpty());
    }
}
