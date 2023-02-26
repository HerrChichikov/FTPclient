package org.example;

public class Student{

    Long id;
        String name;        // имя
                    // id

 Student (Long id, String name){

     super();
     this.id = id;
    this.name = name;


    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
