package com.amadejsky.soap_management;

import courses.GetCourseDetailsRequest;
import courses.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsEndpoint {

    private static final String NAMESPACE_URI = "http://in28minutes.com/courses";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();

        // Tworzenie nowego obiektu CourseDetails dla odpowiedzi
        GetCourseDetailsResponse.CourseDetails responseCourseDetails = new GetCourseDetailsResponse.CourseDetails();

        // Przypisywanie wartości z żądania do obiektu odpowiedzi
        GetCourseDetailsRequest.CourseDetails requestCourseDetails = request.getCourseDetails();
        responseCourseDetails.setId(requestCourseDetails.getId());
        responseCourseDetails.setName("Microservices course");
        responseCourseDetails.setDescription("test description");

        // Ustawianie CourseDetails w odpowiedzi
        response.setCourseDetails(responseCourseDetails);
        return response;
    }
}
