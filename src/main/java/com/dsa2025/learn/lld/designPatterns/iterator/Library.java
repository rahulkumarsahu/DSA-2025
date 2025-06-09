package com.dsa2025.learn.lld.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Library implements BookCollection{
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    // it calls concrete implementation of iterator
    public BookIterator createIterator() {
        return new LibraryIterator(books);
    }

}
