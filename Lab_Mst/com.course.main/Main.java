package com.course.main;
import com.course.model.*;
import com.course.service.*;
import com.course.exception.*;
public class Main{
    public static void main(String[] args){
        CourseService cs = new CourseService();
        Course c1 = new Course(1, "Java", 2);
        cs.addCourse(c1);
        Student s1 = new Student(101, "Aman");
        Student s2 = new Student(102, "Riya");
        Student s3 = new Student(103, "Karan");
        try{
            cs.enrollStudent(1, s1);
            cs.enrollStudent(1, s2);
            cs.enrollStudent(1, s3);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        cs.viewCourses();
    }
}
