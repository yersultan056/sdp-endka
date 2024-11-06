package factory;

import kz.sdppj.sdpendka.model.Book;

public class BookFactory {
    public static Book createBook(String title, String author, String publisher, String pages, String genre, String year, String description) {
        return new Book(null, title, author, publisher, pages, genre, year, description);
    }
}
