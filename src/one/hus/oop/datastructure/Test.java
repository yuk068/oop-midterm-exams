package one.hus.oop.datastructure;

public class Test {

    public static void main(String[] args) {
        MyList doubleList = new ArrayMyList();
//        MyGenericList<Double> doubleList = new MyGenericLinkedList<>();
        for (int i = 1; i<= 10; i++) {
            doubleList.insertAtEnd(i * i);
        }
//        doubleList.insert(69.69, 5);
//        doubleList.insert(69.69, doubleList.size());
//        doubleList.insert(123.321, 0);
        System.out.println(doubleList);
        System.out.println(doubleList.size());

//        doubleList.set(420.69, 5);
//        System.out.println(doubleList);
//        System.out.println(doubleList.size());

//        doubleList.remove(0);
//        doubleList.remove(doubleList.size() - 1);
//        System.out.println(doubleList);
//        System.out.println(doubleList.size());
    }

}
