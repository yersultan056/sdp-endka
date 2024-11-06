package kz.sdppj.sdpendka.service;

import kz.sdppj.sdpendka.model.Book;
import kz.sdppj.sdpendka.service.strategy.BookSearch;
import kz.sdppj.sdpendka.service.strategy.SearchStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private long ID = 0;
    private BookSearch searchContext = new BookSearch();

    public void setSearchStrategy(SearchStrategy strategy) {
        searchContext.setStrategy(strategy);
    }

    public List<Book> searchBooks(String query) {
        return searchContext.executeSearch(books, query);
    }

    {
        books.add(new Book(++ID, "Baikens life", "Baiken", "Bays", "800", "life action", "2024", "some bout baik"));
        books.add(new Book(++ID, "Azas life", "Baiken", "Bays", "503", "life action", "2024", "some bout aza"));

    }

    public List<Book> listBooks() {
        return books;
    }

    public void saveBook (Book book) {
        book.setId(++ID);
        books.add(book);
    }

    public void deleteBook (Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public Book getBookById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) return book;
        }
        return null;
    }
}
