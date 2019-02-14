package com.example.library_application.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Book implements Serializable {

    private String title;
    private String description;
    private String[] editors;
    private String[] authors;
    private String publisher;
    private String id;


    private String[] images;





    public Book() {

    }

    public Book(int id, String title, String[] authors, String description, String[] editors) {
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.editors = editors;
    }

    public static Book fromJSONObject(JSONObject json) {
        Book book = new Book();
        try {
            book.title = json.getString("title");
        } catch (JSONException ex) {
        }

        try {
            book.id = json.getString("id");
        } catch (JSONException ex) {
        }

        try {
            book.editors = loadStringArray(json.getJSONArray("editors"));
        } catch (JSONException ex) {
            book.authors = new String[0];
        }

        try {
            book.description = json.getString("description");
        } catch (JSONException ex) {
        }

        try {
            book.publisher = json.getString("publisher");
        } catch (JSONException ex) {
        }

        try {
            book.authors = loadStringArray(json.getJSONArray("authors"));
        } catch (JSONException ex) {
            book.authors = new String[0];
        }


        try {
            book.images = loadStringArray(json.getJSONArray("images"));
        } catch (JSONException ex) {
            book.authors = new String[0];
        }

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


    public String getEditors() {
        return editors.length > 0 ? editors[0] : null;

    }


    public String getAuthors() {
        return authors.length > 0 ? authors[0] : null;
    }


    public String getPublisher() {
        return publisher;
    }


    public String[] getImages() {
        return images;
    }


    public String getId() {
        return id;
    }


    @Override
    public String toString() //reference or put in memory?
    {
        return "[" + this.getTitle() + " by " + this.getAuthors() + "\n > " + this.getDescription() + "\n";
    }

    private static String[] loadStringArray(JSONArray array) {

        String[] stringArray = new String[array.length()];
        try {

            for (int i = 0; i <= array.length(); i++) {
                stringArray[i] = array.getString(i);
            }


        } catch (JSONException ex) {
        }
        ;

        return stringArray;
    }
}





