package kz.sdppj.sdpendka.service.chain;

import kz.sdppj.sdpendka.model.Book;
import kz.sdppj.sdpendka.model.ValidationException;

public class YearValidatorHandler extends BookHandler {
    @Override
    public boolean handle(Book book) {
        try {
            Integer.parseInt(book.getYear()); // Проверка на число
        } catch (NumberFormatException e) {
            throw new ValidationException("Year must be a number.");
        }
        return checkNext(book);
    }
}
