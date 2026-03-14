package com.course.model;
import java.util.ArrayList;
public class Course{
    int courseId;
    String courseName;
    int maxSeats;
    ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    public Course(int id, String name, int seats){
        courseId = id;
        courseName = name;
        maxSeats = seats;
    }
    public int getCourseId(){ 
      return courseId; 
    }
    public String getCourseName(){ 
      return courseName; 
    }
    public int getMaxSeats(){ 
      return maxSeats; 
    }
    public ArrayList<Student> getEnrolledStudents(){ 
      return enrolledStudents; 
    }
    public void display(){
        System.out.println(courseId + " " + courseName + " Seats:" + maxSeats +
                " Enrolled:" + enrolledStudents.size());
    }
}
