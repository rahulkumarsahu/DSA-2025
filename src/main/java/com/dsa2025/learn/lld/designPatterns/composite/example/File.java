package com.dsa2025.learn.lld.designPatterns.composite.example;

public class File extends FileSystemComponent {

    private final int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "- " + name + " (" + size + " KB)");
    }

    @Override
    public int getSize() {
        return size;
    }

}
