package one.hus.oop.datastructure;

public class MyQueue {
    private MyList queueData;

    public MyList getQueueData() {
        return queueData;
    }

    public MyQueue() {
        this.queueData = new LinkedListMyList();
    }

    /**
     * Thêm giá trị vào cuối của queue.
     * @param value
     */
    public void add(int value) {
        queueData.insertAtEnd(value);
    }

    /**
     * Xóa và trả lại giá trị ở đầu của queue.
     * @return
     */
    public int remove() {
        int target = queueData.get(0);
        queueData.remove(0);
        return target;
    }

    /**
     * Kiểm tra xem queue có rỗng hay không.
     * @return true nếu queue không chứa giá trị nào, false nếu queue đã chứa giá trị.
     */
    public boolean isEmpty() {
        return queueData.size() == 0;
    }

    /**
     * Trả lại giá trị ở đầu của queue mà không xóa phần tử.
     * @return giá trị ở vị trí đầu của queue.
     */
    public int peek() {
        return queueData.get(0);
    }

    /**
     * Lấy kích thước của queue.
     * @return
     */
    public int size() {
        return queueData.size();
    }
}
