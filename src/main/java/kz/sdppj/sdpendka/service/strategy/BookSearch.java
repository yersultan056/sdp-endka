package kz.sdppj.sdpendka.service.strategy;

import kz.sdppj.sdpendka.model.Book;
import java.util.List;

public class BookSearch {
    private SearchStrategy strategy;

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> executeSearch(List<Book> books, String query) {
        return strategy.search(books, query);
    }
}

