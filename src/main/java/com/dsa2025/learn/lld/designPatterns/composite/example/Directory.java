package com.dsa2025.learn.lld.designPatterns.composite.example;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemComponent {

    private final List<FileSystemComponent> children;

    public Directory(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "+ " + name + "/ (" + getSize() + " KB total)");

        for (FileSystemComponent child : children) {
            child.display(depth + 1);
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

}
