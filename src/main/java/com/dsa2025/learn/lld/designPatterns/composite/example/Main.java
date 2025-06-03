package com.dsa2025.learn.lld.designPatterns.composite.example;

public class Main {

    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Directory subFolder = new Directory("SubFolder");
        subFolder.add(file1);

        Directory rootFolder = new Directory("Root");
        rootFolder.add(file2);
        rootFolder.add(subFolder);

        rootFolder.showDetails();
    }

}
