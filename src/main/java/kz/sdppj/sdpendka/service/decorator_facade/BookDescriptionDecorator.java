package kz.sdppj.sdpendka.service.decorator_facade;

import kz.sdppj.sdpendka.model.Book;

public class BookDescriptionDecorator implements BookDecorator {
    @Override
    public Book decorate(Book book) {
        book.setDescription("Description: " + book.getDescription());
        return book;
    }
}
