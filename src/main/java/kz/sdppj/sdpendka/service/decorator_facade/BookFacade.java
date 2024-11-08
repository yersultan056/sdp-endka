package kz.sdppj.sdpendka.service.decorator_facade;

import kz.sdppj.sdpendka.model.Book;
import kz.sdppj.sdpendka.service.BookService;
import kz.sdppj.sdpendka.service.strategy.SearchStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookFacade {
    private final BookService bookService;

    public BookFacade(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getAllBooks() {
        return bookService.listBooks();
    }

    public Book getBookById(Long id) {
        return bookService.getBookById(id);
    }

    public void addBook(Book book) {
        bookService.saveBook(book);
    }

    public void removeBook(Long id) {
        bookService.deleteBook(id);
    }

    public void setSearchStrategy(SearchStrategy strategy) {
        bookService.setSearchStrategy(strategy);
    }

    public List<Book> searchBooks(String query) {
        return bookService.searchBooks(query);
    }
}
