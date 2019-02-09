package com.example.library_application.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Book implements Serializable {

    private String title;
    private String description;
    private String editors;
    private String author;
    private String publisher;
    private int id;
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    private String pages;


    public Book(){

    }

    public static Book fromJSONObject(JSONObject json)
    {
        Book book = new Book();
        try {
            book.setTitle(json.getString("title"));
        } catch (JSONException ex) {}

        try {
        book.setId(json.getInt("id"));
        } catch (JSONException ex) {}

        try{
            book.setEditors(json.getString("editors"));
        }catch (JSONException ex) {}

        try{
            book.setDescription(json.getString("description"));
        }catch (JSONException ex) {}

        try{
            book.setPublisher(json.getString("publisher"));
        }catch (JSONException ex) {}

        try{
            book.setAuthor(json.getString("author"));
        }catch (JSONException ex) {}


        return book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditors() {
        return editors;
    }

    public void setEditors(String editors) {
        this.editors = editors;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() //reference or put in memory?
    {
        return "[" + this.getIsbn() + "] \n" + this.getTitle() + " by " + this.getAuthor() + "\n > " + this.getDescription()+"\n" +this.getPages();
    }

}





