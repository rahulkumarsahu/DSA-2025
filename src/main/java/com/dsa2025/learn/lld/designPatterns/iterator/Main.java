package com.dsa2025.learn.lld.designPatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        Iterator<String> it = fruits.iterator(); // Get the iterator

        while (it.hasNext()) {
            String fruit = it.next();  // Get the next element
            System.out.println(fruit);

            if (fruit.equals("Banana")) {
                it.remove(); // Safe removal using Iterator
            }
        }

        System.out.println("After removal: " + fruits); // [Apple, Mango]

        Library library = new Library();
        library.addBook(new Book("The Alchemist"));
        library.addBook(new Book("1984"));
        library.addBook(new Book("Clean Code"));

        BookIterator iterator = library.createIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("Book: " + book.getTitle());
        }
    }
}
/*
 * public static void main(String[] args) {
 *         ArrayList<String> fruits = new ArrayList<>();
 *         fruits.add("Apple");
 *         fruits.add("Banana");
 *         fruits.add("Mango");
 *
 *         Iterator<String> it = fruits.iterator(); // Get the iterator
 *
 *         while (it.hasNext()) {
 *             String fruit = it.next();  // Get the next element
 *             System.out.println(fruit);
 *
 *             if (fruit.equals("Banana")) {
 *                 it.remove(); // Safe removal using Iterator
 *             }
 *         }
 *
 *         System.out.println("After removal: " + fruits); // [Apple, Mango]
 *     }
 */
