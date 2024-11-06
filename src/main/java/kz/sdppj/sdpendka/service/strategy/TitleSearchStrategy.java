package kz.sdppj.sdpendka.service.strategy;

import kz.sdppj.sdpendka.model.Book;
import java.util.List;
import java.util.stream.Collectors;

public class TitleSearchStrategy implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(query))
                .collect(Collectors.toList());
    }
}
