package com.dsa2025.learn.lld.designPatterns.iterator;

import java.util.List;

public class LibraryIterator implements BookIterator {
    private List<Book> books;
    private int index = 0;

    public LibraryIterator(List<Book> books) {
        this.books = books;
    }

    public boolean hasNext() {
        return index < books.size();
    }

    public Book next() {
        return books.get(index++);
    }

}
