package com.course.service;
import com.course.model.*;
import com.course.exception.*;
import java.util.*;
import java.io.*;
public class CourseService{
    ArrayList<Course> courses = new ArrayList<Course>();
    public void addCourse(Course c){
        courses.add(c);
    }
    public void enrollStudent(int courseId, Student s)
            throws CourseNotFoundException, CourseFullException, DuplicateEnrollmentException{
        Course c = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId() == courseId) {
                c = courses.get(i);
            }
        }
        if (c == null)
            throw new CourseNotFoundException("Course not found");
        if (c.getEnrolledStudents().size() >= c.getMaxSeats())
            throw new CourseFullException("Course full");
        for (int i = 0; i < c.getEnrolledStudents().size(); i++) {
            if (c.getEnrolledStudents().get(i).getStudentId() == s.getStudentId())
                throw new DuplicateEnrollmentException("Already enrolled");
        }
        c.getEnrolledStudents().add(s);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("courses.txt", true));
            bw.write(s.getStudentId() + " " + s.getStudentName() + " -> Course " + courseId);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("File write error");
        }
    }
    public void viewCourses(){
        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).display();
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader("courses.txt"));
            String line;
            System.out.println("Enrollment Records:");
            while ((line = br.readLine()) != null)
                System.out.println(line);
            br.close();
        } catch (Exception e) {
            System.out.println("File read error");
        }
    }
}
