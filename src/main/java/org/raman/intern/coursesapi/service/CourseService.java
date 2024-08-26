package org.raman.intern.coursesapi.service;

import org.raman.intern.coursesapi.entity.Course;
import org.raman.intern.coursesapi.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public String createCourse(Course course) {
        courseRepository.save(course);
        return "Course created";
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public String deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return "Course deleted";
    }
}
