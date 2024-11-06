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

        books.add(new Book(++ID, "The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", "277", "Fiction", "1951", "A novel about a disillusioned teenager."));
        books.add(new Book(++ID, "To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", "281", "Fiction", "1960", "A story of racial injustice in the Deep South."));
        books.add(new Book(++ID, "1984", "George Orwell", "Secker & Warburg", "328", "Dystopian", "1949", "A dystopian novel about totalitarianism."));
        books.add(new Book(++ID, "The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", "180", "Fiction", "1925", "A story of wealth, love, and betrayal in the Jazz Age."));
        books.add(new Book(++ID, "Moby-Dick", "Herman Melville", "Harper & Brothers", "585", "Adventure", "1851", "The journey of the whaling ship Pequod."));
        books.add(new Book(++ID, "Pride and Prejudice", "Jane Austen", "T. Egerton", "279", "Romance", "1813", "A story of love and manners in 19th century England."));
        books.add(new Book(++ID, "The Hobbit", "J.R.R. Tolkien", "George Allen & Unwin", "310", "Fantasy", "1937", "Bilbo Baggins' adventure to reclaim treasure."));
        books.add(new Book(++ID, "The Lord of the Rings: The Fellowship of the Ring", "J.R.R. Tolkien", "George Allen & Unwin", "423", "Fantasy", "1954", "The first book in the epic Lord of the Rings trilogy."));
        books.add(new Book(++ID, "The Picture of Dorian Gray", "Oscar Wilde", "Lippincott's Monthly Magazine", "254", "Philosophical Fiction", "1890", "A story exploring the relationship between beauty, morality, and corruption."));
        books.add(new Book(++ID, "The Importance of Being Earnest", "Oscar Wilde", "Lindsay and Blakiston", "120", "Comedy", "1895", "A satirical comedy of manners about love and mistaken identities."));
        books.add(new Book(++ID, "Baikens life", "Baiken", "Bays", "800", "life action", "2024", "some bout baik"));
        books.add(new Book(++ID, "Azas life", "Baiken", "Bays", "503", "life action", "2024", "some bout aza"));
        books.add(new Book(++ID, "Brave New World", "Aldous Huxley", "Chatto & Windus", "311", "Dystopian", "1932", "A visionary dystopian novel about a technologically advanced, but soulless society."));

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
