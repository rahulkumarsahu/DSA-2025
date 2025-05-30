package com.dsa2025.learn.lld.designPatterns.builder;

public class Client {

    public static void main(String[] args){
        // Engineering Student Builder is an extension of student builder....
        Director directorObj1 = new Director(new EngineeringStudentBuilder());
        Director directorObj2 = new Director(new MBAStudentBuilder());

        Student engineerStudent = directorObj1.createStudent();
        Student mbaStudent =directorObj2.createStudent();

        System.out.println(engineerStudent.toString());
        System.out.println(mbaStudent.toString());

    }
}
