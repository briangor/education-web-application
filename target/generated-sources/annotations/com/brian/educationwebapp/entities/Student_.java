package com.brian.educationwebapp.entities;

import com.brian.educationwebapp.entities.Course;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-29T12:56:29")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Integer> studentid;
    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Course> course;
    public static volatile SingularAttribute<Student, Date> updatedOn;

}