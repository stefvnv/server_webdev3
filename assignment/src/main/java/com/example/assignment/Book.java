package com.example.assignment;

public class Book {

    //private fields/attributes
    private String title;
    private String author;


    //public constructor from fields
    public Book (String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    //public setters and getters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
