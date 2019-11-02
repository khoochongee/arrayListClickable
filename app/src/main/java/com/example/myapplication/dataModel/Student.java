package com.example.myapplication.dataModel;

public class Student{
    private String studentName;
    private String studentID;
    private String studentCourse;

    public Student() {
        this.studentName="";
        this.studentID="";
        this.studentCourse="";
    }

    public Student(String name,String id,String course){
        this.studentName=name;
        this.studentID=id;
        this.studentCourse=course;
    }

    //get student name
    public String getStudentName(){
        return this.studentName;
    }
    //set student name
    public void setStudentName(String n){
        this.studentName=n;
    }

    //get student id
    public String getStudentID(){
        return this.studentID;
    }
    //set student id
    public void setStudentID(String id){
        this.studentID=id;
    }

    //get student course
    public String getStudentCourse(){
        return this.studentCourse;
    }
    //set student course
    public void setStudentCourse(String course){
        this.studentCourse=course;
    }

}
