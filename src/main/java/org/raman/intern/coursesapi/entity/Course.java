package org.raman.intern.coursesapi.entity;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseTitle;
    private String courseCode;
    private String courseDescription;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseDelivery> deliveryList = new LinkedList<>();

    public Course(Long id, String courseTitle, String courseCode, String courseDescription, List<CourseDelivery> deliveryList) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.deliveryList = deliveryList;
    }

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<CourseDelivery> getDeliveryList() {
        return deliveryList;
    }

    public void setDeliveryList(List<CourseDelivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", deliveryList=" + deliveryList +
                '}';
    }
}

