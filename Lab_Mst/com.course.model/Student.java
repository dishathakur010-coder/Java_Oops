package com.course.model;
public class Student {
    int studentId;
    String studentName;
    public Student(int id, String name){
        studentId = id;
        studentName = name;
    }
    public int getStudentId(){ 
      return studentId; 
    }
    public String getStudentName(){ 
      return studentName; 
    }
    public void display(){
        System.out.println(studentId + " " + studentName);
    }
}
