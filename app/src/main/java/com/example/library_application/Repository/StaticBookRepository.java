package com.example.library_application.Repository;

import com.example.library_application.Model.Book;

public class StaticBookRepository extends BookRepository {
    @Override
    public Book[] getBooks() {
        Book exampleBook = new Book();
        exampleBook.setId(123);
        exampleBook.setTitle("Example Book");
        exampleBook.setAuthor("Mrs Example");
        exampleBook.setDescription("This is an example book");
        exampleBook.setEditors("Editor 1");

        return new Book[] {
                exampleBook
        };
    }
}
