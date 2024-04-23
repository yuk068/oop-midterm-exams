package two.hus.oop.bookmanager;

import java.util.Comparator;

public interface MyBookComparator extends Comparator<Book> {

    static Comparator<Book> byTitle() {
        return Comparator.comparing(Book::getTitle);
    }

    static Comparator<Book> byGenre() {
        return Comparator.comparing(Book::getGenre);
    }

    static Comparator<Book> byAuthor() {
        return Comparator.comparing(Book::getAuthor);
    }

    static Comparator<Book> byPages() {
        return Comparator.comparingInt(Book::getPages);
    }

    static Comparator<Book> byPrice() {
        return Comparator.comparingDouble(Book::getPrice);
    }

    static Comparator<Book> byPublisher() {
        return Comparator.comparing(Book::getPublisher);
    }

}
