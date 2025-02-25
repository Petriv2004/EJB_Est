/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petriv.dao;

import com.petriv.model.Course;
import com.petriv.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author RayAj
 */
@Stateless
public class StudentDao implements StudentDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addStudent(Student student) {
        em.persist(student);
    }

    @Override
    public void editStudent(Student student) {
        em.merge(student);
    }

    @Override
    public void deleteStudent(int StudentId) {
        em.remove(getStudent(StudentId));
    }

    @Override
    public Student getStudent(int studentId) {
        return em.find(Student.class, studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        return em.createNamedQuery("Student.getAll").getResultList();
    }

    @Override
    public void enrollStudentInCourse(int studentId, int courseId) {
        Student student = em.find(Student.class, studentId);
        Course course = em.find(Course.class, courseId);
        if (student != null && course != null) {
            student.getCourses().add(course);
            course.getStudents().add(student);
            em.merge(student);
            em.merge(course);
        }
    }

    @Override
    public void removeStudentFromCourse(int studentId, int courseId) {
        try {
//            Query query = em.createNativeQuery("DELETE FROM STUDENT_COURSE WHERE student_id = ? AND course_id = ?");
//            query.setParameter(1, studentId);
//            query.setParameter(2, courseId);
//            query.executeUpdate();
            Student student = em.find(Student.class, studentId);
            Course course = em.find(Course.class, courseId);
            if (student != null && course != null) {
                student.getCourses().remove(course);
                course.getStudents().remove(student);
                em.merge(student);
                em.merge(course);
                em.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        Student student = em.find(Student.class, studentId);
        return (student != null) ? new ArrayList<>(student.getCourses()) : new ArrayList<>();
    }

}
