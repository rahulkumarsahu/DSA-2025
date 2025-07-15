package com.dsa2025.learn.lld.designPatterns.composite.example;

public class Main {

    public static void main(String[] args) {
        // Create root directory
        Directory root = new Directory("root");

        // Create files
        File file1 = new File("readme.txt", 5);
        File file2 = new File("config.xml", 3);

        // Create subdirectories
        Directory documents = new Directory("documents");
        Directory photos = new Directory("photos");

        // Create files in subdirectories
        File doc1 = new File("report.pdf", 150);
        File doc2 = new File("presentation.ppt", 200);
        File photo1 = new File("vacation.jpg", 500);
        File photo2 = new File("family.jpg", 300);

        // Build the file system structure
        root.add(file1);
        root.add(file2);
        root.add(documents);
        root.add(photos);

        documents.add(doc1);
        documents.add(doc2);

        photos.add(photo1);
        photos.add(photo2);

        // Display the entire file system
        System.out.println("File System Structure:");
        root.display(0);

        System.out.println("\nTotal size: " + root.getSize() + " KB");

        // Demonstrate adding new files
        System.out.println("\nAdding new file to documents...");
        documents.add(new File("notes.txt", 2));

        System.out.println("\nUpdated structure:");
        root.display(0);
        System.out.println("New total size: " + root.getSize() + " KB");
    }

}
