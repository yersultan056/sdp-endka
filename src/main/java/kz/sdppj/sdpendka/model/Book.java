package kz.sdppj.sdpendka.model;

import lombok.Data;

@Data
public class Book {
    private long id;
    private String title;
    private String author;
    private String publisher;
    private String pages;
    private String genre;
    private String year;
    private String description;
    private String url;
}