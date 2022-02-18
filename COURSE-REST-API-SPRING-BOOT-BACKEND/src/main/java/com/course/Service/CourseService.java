package com.course.Service;

import java.util.List;

import com.course.model.CourseInfo;

public interface CourseService {

	public List<CourseInfo> getCourse();

	public void deleteCourse(String courseId) throws ClassNotFoundException, InstantiationException, IllegalAccessException;

	public CourseInfo addCourse(CourseInfo courseInfo);

	public CourseInfo updateCourse(CourseInfo courseInfo) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
