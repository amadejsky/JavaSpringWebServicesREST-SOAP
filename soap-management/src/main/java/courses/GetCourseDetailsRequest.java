package courses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "courseDetails"
})
@XmlRootElement(name = "GetCourseDetailsRequest", namespace = "http://in28minutes.com/courses")
public class GetCourseDetailsRequest {

    @XmlElement(name = "CourseDetails", namespace = "http://in28minutes.com/courses", required = true)
    protected CourseDetails courseDetails;

    public CourseDetails getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(CourseDetails value) {
        this.courseDetails = value;
    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "id",
            "name",
            "description"
    })
    public static class CourseDetails {

        @XmlElement(namespace = "http://in28minutes.com/courses", required = true)
        protected int id;

        @XmlElement(namespace = "http://in28minutes.com/courses")
        protected String name;

        @XmlElement(namespace = "http://in28minutes.com/courses")
        protected String description;

        public int getId() {
            return id;
        }

        public void setId(int value) {
            this.id = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}