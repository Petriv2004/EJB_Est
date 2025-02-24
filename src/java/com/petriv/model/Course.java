/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petriv.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author RayAj
 */
@Entity
@Table
@NamedQueries(@NamedQuery(name = "Course.getAll", query = "SELECT c FROM Course c"))
public class Course implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int courseId;
    
    @Column
    private String name;
    
    @Column
    private int credits;
    
    @Column
    private int semester;
    
    @Column
    private int maxStudents;
    
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course(int courseId, String name, int credits, int semester, int maxStudents) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.semester = semester;
        this.maxStudents = maxStudents;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
