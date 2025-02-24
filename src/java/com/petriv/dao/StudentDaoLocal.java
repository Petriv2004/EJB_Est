/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petriv.dao;

import com.petriv.model.Course;
import com.petriv.model.Student;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RayAj
 */
@Local
public interface StudentDaoLocal {

    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(int StudentId);

    Student getStudent(int studentId);

    List <Student> getAllStudent();
    
    void enrollStudentInCourse(int studentId, int courseId);
    
    void removeStudentFromCourse(int studentId, int courseId);
    
    List<Course> getCoursesByStudentId(int studentId);
 
}
