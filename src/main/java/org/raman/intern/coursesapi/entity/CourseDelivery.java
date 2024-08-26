package org.raman.intern.coursesapi.entity;

import jakarta.persistence.*;
import java.time.Year;

@Entity
public class CourseDelivery {

    @Id
    @GeneratedValue
    private Long id;
    private Year deliveryYear;
    private int semester;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public CourseDelivery(Long id, Year deliveryYear, int semester, Course course) {
        this.id = id;
        this.deliveryYear = deliveryYear;
        this.semester = semester;
        this.course = course;
    }

    public CourseDelivery() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Year getDeliveryYear() {
        return deliveryYear;
    }

    public void setDeliveryYear(Year deliveryYear) {
        this.deliveryYear = deliveryYear;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseDelivery{" +
                "id=" + id +
                ", deliveryYear=" + deliveryYear +
                ", semester=" + semester +
                ", course=" + course +
                '}';
    }
}
