package com.amadejsky.soap_management;

import com.amadejsky.soap_management.soap.bean.Course;
import com.amadejsky.soap_management.soap.service.CourseDetailsService;
import courses.GetAllCourseDetailsRequest;
import courses.GetAllCourseDetailsResponse;
import courses.GetCourseDetailsRequest;
import courses.GetCourseDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CourseDetailsEndpoint {
    @Autowired
    CourseDetailsService service;
    private static final String NAMESPACE_URI = "http://in28minutes.com/courses";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {

        Course course = service.findById(request.getCourseDetails().getId());
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();

        // Tworzenie nowego obiektu CourseDetails dla odpowiedzi
        return mapCourseDetails(request, course, response);
    }

    private static GetCourseDetailsResponse mapCourseDetails(GetCourseDetailsRequest request, Course course, GetCourseDetailsResponse response) {
        GetCourseDetailsResponse.CourseDetails responseCourseDetails = mapCourse(request, course);

        // Ustawianie CourseDetails w odpowiedzi
        response.setCourseDetails(responseCourseDetails);
        return response;
    }

    private static GetCourseDetailsResponse.CourseDetails mapCourse(GetCourseDetailsRequest request, Course course) {
        GetCourseDetailsResponse.CourseDetails responseCourseDetails = new GetCourseDetailsResponse.CourseDetails();

        // Przypisywanie wartości z żądania do obiektu odpowiedzi
        GetCourseDetailsRequest.CourseDetails requestCourseDetails = request.getCourseDetails();
        responseCourseDetails.setId(course.getId());
        responseCourseDetails.setName(course.getName());
        responseCourseDetails.setDescription(course.getDescription());
        return responseCourseDetails;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {

        List<Course> courses = service.findAll();
        

    }

}
