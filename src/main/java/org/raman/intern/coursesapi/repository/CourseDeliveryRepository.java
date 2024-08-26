package org.raman.intern.coursesapi.repository;

import org.raman.intern.coursesapi.entity.Course;
import org.raman.intern.coursesapi.entity.CourseDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;
@Repository
public interface CourseDeliveryRepository extends JpaRepository<CourseDelivery,Long> {
    List<CourseDelivery> findAllByDeliveryYearAndSemester(Year year, int semester);
    CourseDelivery findByCourseAndDeliveryYearAndSemester(Course course, Year deliveryYear, int semester);
    void deleteByCourseAndDeliveryYearAndSemester(Course course, Year year, int semester);

}
