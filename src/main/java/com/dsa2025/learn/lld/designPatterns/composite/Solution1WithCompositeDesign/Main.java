package com.dsa2025.learn.lld.designPatterns.composite.Solution1WithCompositeDesign;

public class Main {
    public static void main(String args[]){

       Directory movieDirectory = new Directory("Movie");

        FileSystem border = new File("Border");
        movieDirectory.add(border);

       Directory comedyMovieDirectory = new Directory("ComedyMovie");
       File hulChul = new File("Hulchul");
       comedyMovieDirectory.add(hulChul);
       File heraPheri = new File("Hera Pheri");
       comedyMovieDirectory.add(heraPheri);
       movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();

    }
}
