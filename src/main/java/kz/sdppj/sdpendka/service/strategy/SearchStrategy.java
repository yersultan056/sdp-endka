package kz.sdppj.sdpendka.service.strategy;

import kz.sdppj.sdpendka.model.Book;

import java.util.List;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String query);
}