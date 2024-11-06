package kz.sdppj.sdpendka.controller;

import kz.sdppj.sdpendka.model.Book;
import kz.sdppj.sdpendka.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public String books(Model model) {
        model.addAttribute("books", bookService.listBooks());
        return "index";
    }

    @PostMapping("/book/create")
    public String createBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }

    @GetMapping("/book/{id}")
    public String bookInfo(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "book-info";
    }
}
