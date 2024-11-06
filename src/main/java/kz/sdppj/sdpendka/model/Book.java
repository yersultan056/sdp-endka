package kz.sdppj.sdpendka.model;

import kz.sdppj.sdpendka.controller.CloneableBook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Book implements CloneableBook {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String pages;
    private String genre;
    private String year;
    private String description;

    @Override
    public Book clone() {
        return new Book(null, this.title, this.author, this.publisher, this.pages, this.genre, this.year, this.description);
    }
}
