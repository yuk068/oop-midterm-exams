package two.hus.oop.bookmanager;

import java.util.LinkedList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        bookList = new LinkedList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * Kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index <= limit;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        bookList.addFirst(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAPos(Book book, int index) {
        if (!checkBoundaries(index, bookList.size())) throw new IndexOutOfBoundsException();
        bookList.add(index, book);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        if (!checkBoundaries(index, bookList.size() - 1)) throw new IndexOutOfBoundsException();
        bookList.remove(index);
    }

    /**
     * Bỏ book như tham số truyền vào.
     * @param book
     */
    public void remove(Book book) {
        bookList.remove(book);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        if (!checkBoundaries(index, bookList.size() - 1)) throw new IndexOutOfBoundsException();
        return bookList.get(index);
    }

    /**
     * Sắp xếp danh sách book theo thứ tự tăng dần theo title.
     * @return
     */
    public List<Book> sortIncreasingByTitle() {
        List<Book> toSort = new LinkedList<>(bookList);
        toSort.sort(MyBookComparator.byTitle());
        return toSort;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo title tăng dần, nếu title như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortIncreasingTitleAndPrice() {
        List<Book> toSort = new LinkedList<>(bookList);
        toSort.sort(MyBookComparator.byTitle().thenComparing(MyBookComparator.byPrice()));
        return toSort;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo title giảm dần, nếu title như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortDecreasingTitleAndPrice() {
        List<Book> toSort = new LinkedList<>(bookList);
        toSort.sort(MyBookComparator.byTitle().thenComparing(MyBookComparator.byPrice()).reversed());
        return toSort;
    }

    /**
     * Sắp xếp book theo giá tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        List<Book> toSort = new LinkedList<>(bookList);
        toSort.sort(MyBookComparator.byPrice());
        return toSort;
    }

    /**
     * Sắp xếp book theo giá giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        List<Book> toSort = new LinkedList<>(bookList);
        toSort.sort(MyBookComparator.byPrice().reversed());
        return toSort;
    }

    /**
     * Sắp xếp book theo số trang tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPages() {
        List<Book> toSort = new LinkedList<>(bookList);
        toSort.sort(MyBookComparator.byPages());
        return toSort;
    }

    /**
     * Sắp xếp book theo số trang giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPages() {
        List<Book> toSort = new LinkedList<>(bookList);
        toSort.sort(MyBookComparator.byPages().reversed());
        return toSort;
    }

    /**
     * Lọc ra howMany book có giá lớn nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterHighestPrice(int howMany) {
        List<Book> toFilter = sortDecreasingPrice();
        return toFilter.stream().limit(howMany).toList();
    }

    public List<Book> filterLowestPrice(int howMany) {
        List<Book> toFilter = sortIncreasingPrice();
        return toFilter.stream().limit(howMany).toList();
    }

    /**
     * Lọc ra những book có giá cao hơn lowerBound.
     * @param lowerBound
     * @return
     */
    public List<Book> filterBooksPriceHigherThan(double lowerBound) {
        List<Book> toFilter = new LinkedList<>(bookList);
        toFilter = toFilter.stream().filter(book -> book.getPrice() > lowerBound).toList();
        return toFilter;
    }

    /**
     * Lọc ra howMany book có số trang nhỏ nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterBookLowestPages(int howMany) {
        List<Book> toFilter = sortIncreasingPages();
        return toFilter.stream().limit(howMany).toList();
    }

    /**
     * Lọc ra howMany book có số trang nhỏ hơn upperBound.
     * @param upperBound
     * @return
     */
    public List<Book> filterBooksPagesLowerThan(double upperBound) {
        List<Book> toFilter = new LinkedList<>(bookList);
        toFilter = toFilter.stream().filter(book -> book.getPages() < upperBound).toList();
        return toFilter;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        List<Book> toFilter = new LinkedList<>(bookList);
        toFilter = toFilter.stream().filter(book -> book.getPublisher().equals(publisher)).toList();
        return toFilter;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        List<Book> toFilter = new LinkedList<>(bookList);
        toFilter = toFilter.stream().filter(book -> book.getGenre().equals(genre)).toList();
        return toFilter;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        List<Book> toFilter = new LinkedList<>(bookList);
        toFilter = toFilter.stream().filter(book -> book.getAuthor().equals(author)).toList();
        return toFilter;
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
