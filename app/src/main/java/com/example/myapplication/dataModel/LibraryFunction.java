package com.example.myapplication.dataModel;

public class LibraryFunction {
    private String functionName;

    public LibraryFunction() {
        this.functionName="";
    }

    public LibraryFunction(String name){
        this.functionName=name;
    }

    //get student name
    public String getLibraryFunction(){
        return this.functionName;
    }
    //set student name
    public void setLibraryFunction(String n){
        this.functionName=n;
    }
    
}
