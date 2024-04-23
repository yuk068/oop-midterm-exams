package one.hus.oop.bookmanager;

import java.util.Comparator;

public interface MyBookComparator extends Comparator<Book> {
    int compare(Book left, Book right);

    static Comparator<Book> titleComparator() {
        return Comparator.comparing(Book::getTitle);
    }

    static Comparator<Book> authorComparator() {
        return Comparator.comparing(Book::getAuthor);
    }

    static Comparator<Book> genreComparator() {
        return Comparator.comparing(Book::getGenre);
    }

    static Comparator<Book> pagesComparator() {
        return Comparator.comparingInt(Book::getPages);
    }

    static Comparator<Book> priceComparator() {
        return Comparator.comparingDouble(Book::getPrice);
    }

    static Comparator<Book> publisherComparator() {
        return Comparator.comparing(Book::getPublisher);
    }

}
