package com.example.library_application.Repository;

import com.example.library_application.Model.Book;

public class StaticBookRepository extends BookRepository {
    @Override
    protected Book[] getBooksInternal() {
        Book exampleBook = new Book(
                123,
                "Example Book",
                new String[] {"Mrs Example", "Mr Example"},
                "This is an example book",
                new String[] {"Editor 1", "Editor 2"}
                );


        return new Book[] {
                exampleBook
        };
    }
}
