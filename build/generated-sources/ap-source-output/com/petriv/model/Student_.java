package com.petriv.model;

import com.petriv.model.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-02-23T16:23:48")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Integer> studentId;
    public static volatile ListAttribute<Student, Course> courses;
    public static volatile SingularAttribute<Student, String> firstname;
    public static volatile SingularAttribute<Student, Integer> yearLevel;
    public static volatile SingularAttribute<Student, String> lastname;

}