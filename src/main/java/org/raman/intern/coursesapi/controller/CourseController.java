package org.raman.intern.coursesapi.controller;
import org.raman.intern.coursesapi.entity.Course;
import org.raman.intern.coursesapi.entity.CourseDelivery;
import org.raman.intern.coursesapi.service.CourseDeliveryService;
import org.raman.intern.coursesapi.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class CourseController {
    private final CourseService courseService;
    private final CourseDeliveryService courseDeliveryService;

    public CourseController(CourseService courseService, CourseDeliveryService courseDeliveryService) {
        this.courseService = courseService;
        this.courseDeliveryService = courseDeliveryService;
    }

    //1.
    @PostMapping("/courses")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        String created = courseService.createCourse(course);
        return new ResponseEntity<String>(created, HttpStatus.CREATED);
    }

    //2.
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> list = courseService.getAllCourses();
        if(list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //3.
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        Course course = courseService.getCourse(id);
        if(course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    //4.
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        String deleted = courseService.deleteCourse(id);
        if(deleted.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    //5.
    @PostMapping("/instances")
    public ResponseEntity<String> addCourseDelivery(@RequestBody CourseDelivery courseDelivery) {
        String created = courseDeliveryService.createDelivery(courseDelivery);
        if(created.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    //6.
    @GetMapping("/instances/{year}/{semester}")
    public ResponseEntity<List<Course>> getAllCourses(@PathVariable Year year, @PathVariable int semester) {
        List<Course> courses = courseDeliveryService.fetchAllDeliveriesFromYearAndSemester(year, semester);
        if(courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    //7.
    @GetMapping("/instances/{year}/{semester}/{id}")
    public ResponseEntity<CourseDelivery> getCourseDelivery(@PathVariable Year year, @PathVariable int semester, @PathVariable Long id) {
        CourseDelivery deliveryByIdAndYearAndSemester = courseDeliveryService.getDeliveryByIdAndYearAndSemester(id, year, semester);
        if(deliveryByIdAndYearAndSemester == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deliveryByIdAndYearAndSemester, HttpStatus.OK);
    }

    //8.
    @DeleteMapping("/instances/{year}/{semester}/{id}")
    public ResponseEntity<String> deleteCourseDelivery(@PathVariable Year year, @PathVariable int semester, @PathVariable Long id) {
        String deleted = courseDeliveryService.deleteDelivery(id, year, semester);
        if(deleted.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @DeleteMapping("/instances/{id}")
    public ResponseEntity<String> deleteInstance(@PathVariable Long id) {
        String deleted = courseDeliveryService.deleteDeliveryById(id);
        if(deleted.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
