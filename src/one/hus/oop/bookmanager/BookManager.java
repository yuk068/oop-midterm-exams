package one.hus.oop.bookmanager;

import java.util.*;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        bookList = new LinkedList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
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
    public void append(Book book) {
        bookList.add(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
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
        bookList.removeIf(thisBook -> thisBook.equals(book));
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
     * Sắp xếp danh sách book theo thứ tự tăng dần theo genre và sau đó đến title.
     * @return
     */
    public List<Book> sortIncreasingByGenreAndTitle() {
        List<Book> toSort = new ArrayList<>(bookList);
        toSort.sort(MyBookComparator.genreComparator().thenComparing(MyBookComparator.titleComparator()));
        return toSort;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre tăng dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortIncreasingGenreAndPrice() {
        List<Book> toSort = new ArrayList<>(bookList);
        toSort.sort(MyBookComparator.genreComparator().thenComparing(MyBookComparator.priceComparator()));
        return toSort;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre giảm dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortDecreasingGenreAndPrice() {
        List<Book> toSort = new ArrayList<>(bookList);
        toSort.sort(MyBookComparator.genreComparator().thenComparing(MyBookComparator.priceComparator()).reversed());
        return toSort;
    }

    /**
     * Sắp xếp sách theo giá tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        List<Book> toSort = new ArrayList<>(bookList);
        toSort.sort(MyBookComparator.priceComparator());
        return toSort;
    }

    /**
     * Sắp xếp sách theo giá giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        List<Book> toSort = new ArrayList<>(bookList);
        toSort.sort(MyBookComparator.priceComparator().reversed());
        return toSort;
    }

    /**
     * Sắp xếp sách theo số trang tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPages() {
        List<Book> toSort = new ArrayList<>(bookList);
        toSort.sort(MyBookComparator.pagesComparator());
        return toSort;
    }

    /**
     * Sắp xếp sách theo số trang giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPages() {
        List<Book> toSort = new ArrayList<>(bookList);
        toSort.sort(MyBookComparator.pagesComparator().reversed());
        return toSort;
    }

    /**
     * Lọc ra howMany sách có số trang lớn nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterHighestPages(int howMany) {
        List<Book> toFilter = sortDecreasingPages();
        return toFilter.stream().limit(howMany).toList();
    }

    /**
     * Lọc ra những sách có số trang cao hơn lowerBound.
     * @param lowerBound
     * @return
     */
    public List<Book> filterBooksPagesHigherThan(double lowerBound) {
        List<Book> toFilter = new ArrayList<>();
        bookList.stream().filter(book -> book.getPages() > lowerBound).forEach(toFilter::add);
        return toFilter;
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterBookLowestPages(int howMany) {
        List<Book> toFilter = sortIncreasingPages();
        return toFilter.stream().limit(howMany).toList();
    }

    public List<Book> filterBookLowestPrice(int howMany) {
        List<Book> toFilter = sortIncreasingPrice();
        return toFilter.stream().limit(howMany).toList();
    }

    public List<Book> filterBookHighestPrice(int howMany) {
        List<Book> toFilter = sortDecreasingPrice();
        return toFilter.stream().limit(howMany).toList();
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ hơn upperBound.
     * @param upperBound
     * @return
     */
    public List<Book> filterBooksPagesLowerThan(double upperBound) {
        List<Book> toFilter = new ArrayList<>();
        bookList.stream().filter(book -> book.getPages() < upperBound).forEach(toFilter::add);
        return toFilter;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        List<Book> toFilter = new ArrayList<>();
        bookList.stream().filter(book -> book.getPublisher().equals(publisher)).forEach(toFilter::add);
        return toFilter;
    }

    /**
     * Lọc ra những sách theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        List<Book> toFilter = new ArrayList<>();
        bookList.stream().filter(book -> book.getGenre().equals(genre)).forEach(toFilter::add);
        return toFilter;
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        List<Book> toFilter = new ArrayList<>();
        bookList.stream().filter(book -> book.getAuthor().equals(author)).forEach(toFilter::add);
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
