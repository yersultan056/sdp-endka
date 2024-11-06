package kz.sdppj.sdpendka.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String pages;
    private String genre;
    private String year;
    private String description;
}