package one.hus.oop.datastructure;

public class LinkedListMyList extends AbstractMyList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public LinkedListMyList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        checkBoundaries(index, size - 1);
        return getNodeByIndex(index).getData();
    }

    /**
     * Sửa dữ liệu ở vị trí index thành one.data.
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        checkBoundaries(index, size - 1);
        getNodeByIndex(index).setData(data);
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPos(int value, int index) {
        checkBoundaries(index, size);
        if (index == 0) {
            insertAtStart(value);
        } else if (index >= size) {
            insertAtEnd(value);
        } else {
            Node temp = new Node(value);
            Node current = getNodeByIndex(index);

            temp.setNext(current);
            temp.setPrev(current.getPrev());
            current.getPrev().setNext(temp);
            current.setPrev(temp);

            size++;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        checkBoundaries(index, size - 1);
        if (head == null || tail == null) return;
        if (index == 0) {
            removeAtStart();
        } else if (index == size - 1) {
            removeAtEnd();
        } else {
            Node nodeToRemove = getNodeByIndex(index);
            Node prevNode = nodeToRemove.getPrev();
            Node nextNode = nodeToRemove.getNext();

            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);

            nodeToRemove.setPrev(null);
            nodeToRemove.setNext(null);

            size--;
        }
    }

    public void removeAtStart() {
        if (head == null) return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node toRemove = head;
            head = head.getNext();
            head.setPrev(null);
            toRemove.setNext(null);
        }
        size--;
    }

    public void removeAtEnd() {
        if (tail == null) return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node toRemove = tail;
            tail = tail.getPrev();
            tail.setNext(null);
            toRemove.setPrev(null);
        }
        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        checkBoundaries(index, size - 1);
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public int[] toArray() {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = getNodeByIndex(i).getData();
        }
        return array;
    }

}
