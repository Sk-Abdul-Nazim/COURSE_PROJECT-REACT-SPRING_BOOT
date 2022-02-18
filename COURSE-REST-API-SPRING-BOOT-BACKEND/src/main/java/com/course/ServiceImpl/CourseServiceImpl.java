package com.course.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.Dao.CourseDao;
import com.course.Service.CourseService;
import com.course.model.CourseInfo;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao; 
	
	@Override
	public List<CourseInfo> getCourse(){
		
		List<CourseInfo> ci = courseDao.getCourse();
		
		return ci;
	}
	
	public void deleteCourse(String courseId) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		boolean  c = courseDao.deleteCourse(courseId);
		
		
	}

	@Override
	public CourseInfo addCourse(CourseInfo courseInfo) {

		CourseInfo cf = courseDao.addCourse(courseInfo);
		return cf;
	}
	
	@Override
	public CourseInfo updateCourse(CourseInfo courseInfo) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		CourseInfo cf = courseDao.updateCourse(courseInfo);
		return cf;
	}

}
