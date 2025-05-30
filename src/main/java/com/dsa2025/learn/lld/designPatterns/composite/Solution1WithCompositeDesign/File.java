package com.dsa2025.learn.lld.designPatterns.composite.Solution1WithCompositeDesign;

public class File implements FileSystem{
    String fileName;

    public File(String name){
        this.fileName = name;
    }

    public void ls(){
        System.out.println("file name " + fileName);
    }
}
