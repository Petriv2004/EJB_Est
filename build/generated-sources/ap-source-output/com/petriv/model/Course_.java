package com.petriv.model;

import com.petriv.model.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-02-23T22:49:01")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Integer> credits;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, Integer> maxStudents;
    public static volatile ListAttribute<Course, Student> students;
    public static volatile SingularAttribute<Course, Integer> semester;
    public static volatile SingularAttribute<Course, Integer> courseId;

}