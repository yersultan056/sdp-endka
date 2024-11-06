package kz.sdppj.sdpendka.service.chain;

import kz.sdppj.sdpendka.model.Book;
import kz.sdppj.sdpendka.model.ValidationException;

public class TitleValidatorHandler extends BookHandler {
    @Override
    public boolean handle(Book book) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new ValidationException("Title is required.");
        }
        return checkNext(book);
    }
}
