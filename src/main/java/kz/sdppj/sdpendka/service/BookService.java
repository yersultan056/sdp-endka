package kz.sdppj.sdpendka.service;

import kz.sdppj.sdpendka.model.Book;
import kz.sdppj.sdpendka.model.ValidationException;
import kz.sdppj.sdpendka.service.chain.*;
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
    private BookHandler validator;

    public BookService() {
        this.validator = new TitleValidatorHandler();
        validator.linkWith(new AuthorValidatorHandler())
                .linkWith(new PagesValidatorHandler())
                .linkWith(new YearValidatorHandler());
    }

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

    public void saveBook(Book book) {
        try {
            if (!validator.handle(book)) {
                throw new ValidationException("Invalid book data.");
            }
            book.setId(++ID);
            books.add(book);
        } catch (ValidationException e) {
            throw e;
        }
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
