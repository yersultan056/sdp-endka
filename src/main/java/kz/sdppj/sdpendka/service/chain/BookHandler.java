package kz.sdppj.sdpendka.service.chain;

import kz.sdppj.sdpendka.model.Book;

public abstract class BookHandler {
    private BookHandler nextHandler;

    public BookHandler linkWith(BookHandler next) {
        this.nextHandler = next;
        return next;
    }

    public abstract boolean handle(Book book);

    protected boolean checkNext(Book book) {
        return nextHandler == null || nextHandler.handle(book);
    }
}