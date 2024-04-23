package one.hus.oop.datastructure;

public abstract class AbstractMyList implements MyList {
    /**
     * Phương thức kiểm tra xem index có nằm trong đoạn [0 - limit] không.
     * @param index
     * @param limit
     * @return
     */
    public void checkBoundaries(int index, int limit) {
        if (index < 0 || index > limit) throw new IndexOutOfBoundsException();
    }

    /**
     * Mô tả tập dữ liệu.
     * @return mô tả tập dữ liệu theo định dạng [a1, a2, a3, ..., an].
     */
    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) {
                listString.append(get(i));
            } else {
                listString.append(get(i)).append(", ");
            }
        }
        return listString.append("]").toString();
    }

}
