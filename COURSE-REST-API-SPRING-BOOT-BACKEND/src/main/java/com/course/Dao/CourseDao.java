package com.course.Dao;

import java.util.List;

import com.course.model.CourseInfo;

public interface CourseDao {

	List<CourseInfo> getCourse();

	boolean deleteCourse(String courseId) throws ClassNotFoundException, InstantiationException, IllegalAccessException;

	CourseInfo addCourse(CourseInfo courseInfo);

	CourseInfo updateCourse(CourseInfo courseInfo) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
