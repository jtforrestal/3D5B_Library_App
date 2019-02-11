package com.example.library_application.Repository;

import com.example.library_application.Model.Book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public abstract class BookRepository {
    public abstract Book[] getBooks();

    public Book[] getBooks() {
        Book[] books = this.getBooksInternal();

        return sortBooks(books, new sortByTitleComparator());
    }

    protected abstract Book[] getBooksInternal();

    private Book[] sortBooks(Book[] books, Comparator<Book> comparator) {
        Arrays.sort(books, comparator);
        return books;
    }

    private class sortByTitleComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
