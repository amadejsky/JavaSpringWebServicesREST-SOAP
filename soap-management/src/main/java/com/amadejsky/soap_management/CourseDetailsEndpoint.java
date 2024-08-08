package com.amadejsky.soap_management;

import com.amadejsky.soap_management.soap.bean.Course;
import com.amadejsky.soap_management.soap.service.CourseDetailsService;
import courses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;
import java.util.List;

@Endpoint
public class CourseDetailsEndpoint {
    @Autowired
    private CourseDetailsService service;
    private static final String NAMESPACE_URI = "http://in28minutes.com/courses";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) throws Exception {
        Course course = service.findById(request.getCourseDetails().getId());
        if (course == null) {
            throw new Exception("Invalid Course Id " + request.getCourseDetails().getId());
        }
        return mapCourseDetails(course);
    }

    private GetCourseDetailsResponse mapCourseDetails(Course course) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        response.setCourseDetails(mapCourse(course));
        return response;
    }

    private GetCourseDetailsResponse.CourseDetails mapCourse(Course course) {
        GetCourseDetailsResponse.CourseDetails courseDetails = new GetCourseDetailsResponse.CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        return courseDetails;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
        List<Course> courses = service.findAll();
        return mapAllCourseDetails(courses);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse deleteCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {
        CourseDetailsService.Status status = service.deleteById(request.getId());
        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
        response.setStatus(mapStatus(status));
        return response;
    }

    private CourseDetailsService.Status mapStatus(CourseDetailsService.Status status) {
        if(status==CourseDetailsService.Status.FAILURE)
            return CourseDetailsService.Status.FAILURE;
        return CourseDetailsService.Status.SUCCESS;
    }

    private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        for (Course course : courses) {
            GetCourseDetailsResponse.CourseDetails courseDetails = mapCourse(course);
            response.getCourseDetails().add(courseDetails);
        }
        return response;
    }





}
