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
@XmlRootElement(name = "GetCourseDetailsResponse", namespace = "http://in28minutes.com/courses")
public class GetCourseDetailsResponse {

    @XmlElement(name = "CourseDetails", namespace = "http://in28minutes.com/courses", required = true)
    protected GetCourseDetailsResponse.CourseDetails courseDetails;

    public GetCourseDetailsResponse.CourseDetails getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(GetCourseDetailsResponse.CourseDetails value) {
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
        protected int id;  // Using int instead of BigInteger

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

        public void setName(String value) {
            this.name = value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String value) {
            this.description = value;
        }
    }
}
