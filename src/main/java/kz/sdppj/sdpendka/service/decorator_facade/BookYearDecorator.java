package kz.sdppj.sdpendka.service.decorator_facade;

import kz.sdppj.sdpendka.model.Book;

public class BookYearDecorator implements BookDecorator {
    @Override
    public Book decorate(Book book) {
        book.setYear(book.getYear() + " Year");
        return book;
    }
}
