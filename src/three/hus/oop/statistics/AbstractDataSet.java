package three.hus.oop.statistics;

public abstract class AbstractDataSet implements DataSet {
    /**
     * Mô tả tập dữ liệu.
     * @return mô tả tập dữ liệu dạng [a1, a2, a3, ..., an].
     */

    public static void checkBoundaries(int index, int limit) {
        if (index < 0 || index > limit) throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        StringBuilder dataSet = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) dataSet.append(this.elementAt(i));
            else dataSet.append(this.elementAt(i)).append(", ");
        }
        dataSet.append("]");
        return dataSet.toString();
    }
}
