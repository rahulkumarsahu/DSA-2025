package com.dsa2025.learn.lld.designPatterns.iterator;

// this is aggregate and its concrete impl is Library
public interface BookCollection {

    BookIterator createIterator();

}
