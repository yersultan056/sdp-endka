package kz.sdppj.sdpendka.controller;

import kz.sdppj.sdpendka.model.Book;
import kz.sdppj.sdpendka.model.ValidationException;
import kz.sdppj.sdpendka.service.decorator_facade.BookFacade;
import kz.sdppj.sdpendka.service.strategy.AuthorSearchStrategy;
import kz.sdppj.sdpendka.service.strategy.TitleSearchStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookFacade bookFacade;

    @GetMapping("/")
    public String books(Model model) {
        model.addAttribute("books", bookFacade.getAllBooks());
        return "index";
    }

    @PostMapping("/book/create")
    public String createBook(Book book, Model model) {
        try {
            bookFacade.addBook(book);
        } catch (ValidationException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
        return "redirect:/";
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookFacade.removeBook(id);
        return "redirect:/";
    }

    @GetMapping("/book/{id}")
    public String bookInfo(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookFacade.getBookById(id));
        return "book-info";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String query,
                              @RequestParam String type, Model model) {
        if ("title".equalsIgnoreCase(type)) {
            bookFacade.setSearchStrategy(new TitleSearchStrategy());
        } else if ("author".equalsIgnoreCase(type)) {
            bookFacade.setSearchStrategy(new AuthorSearchStrategy());
        }

        List<Book> result = bookFacade.searchBooks(query);
        model.addAttribute("books", result);
        return "index";
    }

    @GetMapping("/book/clone/{id}")
    public String cloneBook(@PathVariable Long id) {
        Book originalBook = bookFacade.getBookById(id);
        if (originalBook != null) {
            Book clonedBook = originalBook.clone();
            bookFacade.addBook(clonedBook);
        }
        return "redirect:/";
    }

}
