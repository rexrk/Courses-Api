package org.raman.intern.coursesapi.service;

import org.raman.intern.coursesapi.entity.Course;
import org.raman.intern.coursesapi.entity.CourseDelivery;
import org.raman.intern.coursesapi.repository.CourseDeliveryRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseDeliveryService {
    private final CourseDeliveryRepository courseDeliveryRepository;
    private final CourseService courseService;
    public CourseDeliveryService(CourseDeliveryRepository courseDeliveryRepository, CourseService courseService) {
        this.courseDeliveryRepository = courseDeliveryRepository;
        this.courseService = courseService;
    }

    //5. Create a new instance of a course delivery
    public void createDelivery(CourseDelivery delivery) {
        courseDeliveryRepository.save(delivery);
    }

    //6. list of courses delivered in year YYYY=2020, and semester=1
    public List<Course> fetchAllDeliveriesFromYearAndSemester(Year year, int semester) {
        List<CourseDelivery> courseDeliveries = courseDeliveryRepository.findAllByDeliveryYearAndSemester(year, semester);
        return courseDeliveries.stream()
                .map(CourseDelivery::getCourse)
                .collect(Collectors.toList());
    }

    //7. View detailed information about an instance of a course ID = 19, delivered in YYYY=2023, and semester = 1
    public CourseDelivery getDeliveryByIdAndYearAndSemester(Long id, Year year, int semester) {
        Course course = courseService.getCourse(id);
        if(course != null) {
            return courseDeliveryRepository.findByCourseAndDeliveryYearAndSemester(course, year, semester);
        }
        return null;
    }

    //8. Delete  an instance of a course ID = 8, delivered in YYYY=2022, and semester = 2
    public void deleteDelivery(Long id, Year year, int semester) {
        Course course = courseService.getCourse(id);
        if(course != null) {
            courseDeliveryRepository.deleteByCourseAndDeliveryYearAndSemester(course, year, semester);
        }
    }
}