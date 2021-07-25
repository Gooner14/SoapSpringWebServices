package com.spring.soap.webservices.soapspringboot.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.soap.webservices.soapspringboot.soap.bean.Course;

@Component
public class CourseDetailsService {

	private static List<Course> courses = new ArrayList<>();
	static {
		Course course1 = new Course(1, "Spring1", "Desc1");
		Course course2 = new Course(2, "Spring2", "Desc12");
		Course course3 = new Course(3, "Spring3", "Desc13");
		Course course4 = new Course(4, "Spring4", "Desc14");
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
	}
	
	public Course findById(int id) {
		for(Course course:courses) {
			if(course.getId() == id)
				return course;
		}
		return null;
	}
	
	public List<Course> findAll(){
		return courses;
	}
	
	public int deleteById(int id) {
		Iterator<Course> iterator = courses.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId() == id){
				iterator.remove();
				return 1;
			}
		}
		return 0;
	}
	
}
