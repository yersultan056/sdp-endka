package kz.sdppj.sdpendka.service.chain;

import kz.sdppj.sdpendka.model.Book;
import kz.sdppj.sdpendka.model.ValidationException;

public class PagesValidatorHandler extends BookHandler {
    @Override
    public boolean handle(Book book) {
        try {
            Integer.parseInt(book.getPages()); // Проверка на число
        } catch (NumberFormatException e) {
            throw new ValidationException("Pages must be a number.");
        }
        return checkNext(book);
    }
}
