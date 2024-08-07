
package courses;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CourseDetails"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "courseDetails"
})
@XmlRootElement(name = "GetCourseDetailsResponse", namespace = "http://in28minutes.com/courses")
public class GetAllCourseDetailsResponse {

    @XmlElement(name = "CourseDetails", namespace = "http://in28minutes.com/courses", required = true)
    protected GetCourseDetailsResponse.CourseDetails courseDetails;

    /**
     * Gets the value of the courseDetails property.
     *
     * @return
     *     possible object is
     *     {@link GetCourseDetailsResponse.CourseDetails }
     *
     */
    public GetCourseDetailsResponse.CourseDetails getCourseDetails() {
        return courseDetails;
    }

    /**
     * Sets the value of the courseDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link GetCourseDetailsResponse.CourseDetails }
     *
     */
    public void setCourseDetails(GetCourseDetailsResponse.CourseDetails value) {
        this.courseDetails = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "id",
            "name",
            "description"
    })
    public static class CourseDetails {

        @XmlElement(namespace = "http://in28minutes.com/courses", required = true)
        protected BigInteger id;
        @XmlElement(namespace = "http://in28minutes.com/courses")
        protected String name;
        @XmlElement(namespace = "http://in28minutes.com/courses")
        protected String description;

        /**
         * Gets the value of the id property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setId(BigInteger value) {
            this.id = value;
        }

        /**
         * Gets the value of the name property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the description property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDescription(String value) {
            this.description = value;
        }

    }

}