package com.example.library_application.Repository;

import com.example.library_application.Model.Book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public abstract class BookRepository {
    public Book[] findBooksByTitle(String name) {
        Book[] books = this.getBooksInternal();

        List<Book> foundBooks = new LinkedList<Book>();

        for (Book book : books) {
            if (book.getTitle().contains(name)) {
                ((LinkedList<Book>) foundBooks).addFirst(book);
            }
        }

        return sortBooks((Book[])foundBooks.toArray(), new sortByTitleComparator());
    }

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
