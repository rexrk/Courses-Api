package org.raman.intern.coursesapi;

import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import org.hibernate.grammars.hql.HqlParser;
import org.raman.intern.coursesapi.entity.Course;
import org.raman.intern.coursesapi.entity.CourseDelivery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Year;
import java.util.List;

@SpringBootApplication
public class CoursesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursesApiApplication.class, args);

    }

}
