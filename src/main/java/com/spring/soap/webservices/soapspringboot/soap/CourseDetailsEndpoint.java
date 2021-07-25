package com.spring.soap.webservices.soapspringboot.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mywebservice.courses.CourseDetails;
import com.mywebservice.courses.GetAllCourseDetailsRequest;
import com.mywebservice.courses.GetAllCourseDetailsResponse;
import com.mywebservice.courses.GetCourseDetailsRequest;
import com.mywebservice.courses.GetCourseDetailsResponse;
import com.spring.soap.webservices.soapspringboot.soap.bean.Course;
import com.spring.soap.webservices.soapspringboot.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;

	@PayloadRoot(namespace = "http://mywebservice.com/courses", localPart = "GetCourseDetailsRequest")	
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		
		
		Course course = service.findById(request.getId());
		
		return mapCourse(course);
	}

	private GetCourseDetailsResponse mapCourse(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		CourseDetails courseDetails = new CourseDetails();
		
		courseDetails.setId(course.getId());
		courseDetails.setDescription(course.getDescription());
		courseDetails.setName(course.getName());
		
		response.setCourseDetails(courseDetails);
		return response;
	}
	
	private GetAllCourseDetailsResponse mapAllCourse(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		
		for(Course course: courses) {
		CourseDetails courseDetails = new CourseDetails();
		
		courseDetails.setId(course.getId());
		courseDetails.setDescription(course.getDescription());
		courseDetails.setName(course.getName());
		
		response.getCourseDetails().add(courseDetails);
		}
		return response;
	}
	
	@PayloadRoot(namespace = "http://mywebservice.com/courses", localPart = "GetAllCourseDetailsRequest")	
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		
		List<Course> courses = service.findAll();
		return mapAllCourse(courses);
	}
	
}
