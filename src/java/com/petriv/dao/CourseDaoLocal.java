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
public interface CourseDaoLocal {
    
    void addCourse(Course course);
    
    void editCourse(Course course);
    
    void deleteCourse(int courseId);
    
    Course getCourse(int courseId);
    
    List<Course> getAllCourses();
    
    List<Student> getStudentByCourseId(int courseId);
}
