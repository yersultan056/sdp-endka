package kz.sdppj.sdpendka.service.chain;

import kz.sdppj.sdpendka.model.Book;
import kz.sdppj.sdpendka.model.ValidationException;

public class AuthorValidatorHandler extends BookHandler {
    @Override
    public boolean handle(Book book) {
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new ValidationException("Author is required.");
        }
        return checkNext(book);
    }
}
