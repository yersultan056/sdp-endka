package kz.sdppj.sdpendka.service.decorator_facade;

import kz.sdppj.sdpendka.model.Book;

public class BookDecoratorFactory {
    private final BookDecorator descriptionDecorator;
    private final BookDecorator yearDecorator;

    public BookDecoratorFactory() {
        this.descriptionDecorator = new BookDescriptionDecorator();
        this.yearDecorator = new BookYearDecorator();
    }

    public Book decorateBook(Book book) {
        book = descriptionDecorator.decorate(book);
        book = yearDecorator.decorate(book);
        return book;
    }
}
