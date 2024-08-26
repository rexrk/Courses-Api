package org.raman.intern.coursesapi.entity;
import jakarta.persistence.*;
import java.time.Year;
@Entity
public class CourseDelivery {

    @Id
    @GeneratedValue
    private Long CD_ID;
    private Year deliveryYear;
    private int semester;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public CourseDelivery(Long CD_ID, Year deliveryYear, int semester, Course course) {
        this.CD_ID = CD_ID;
        this.deliveryYear = deliveryYear;
        this.semester = semester;
        this.course = course;
    }

    public CourseDelivery() {
    }

    public Long getCD_ID() {
        return CD_ID;
    }

    public void setCD_ID(Long id) {
        this.CD_ID = id;
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
                "id=" + CD_ID +
                ", deliveryYear=" + deliveryYear +
                ", semester=" + semester +
                ", course=" + course +
                '}';
    }
}
