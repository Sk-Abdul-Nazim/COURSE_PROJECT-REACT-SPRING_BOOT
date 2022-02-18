package com.course.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.Service.CourseService;
import com.course.jsonUtil.JsonUtil;
import com.course.model.CourseInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

// @RestController use korar karon value return korche Controller theke (ex: return courseService.getCourse();) 
//just @Controller hole value return korto na sudhu jsp page return korto (ex. return "jsp_page";)
//@RestController er @PathVariable die kono variable ke assign kora hoi.
// @GetMapping("/course/{courseId}") here {courseId} mane url theke value catch korbe. (ex: localhost:8080/course/13). So 13 ta assign hobe {courseId} modhhe.
// @RequestBody mane Pojo Class e data gulo ke assign kora hoi. Here CourseInfo class is a POJO class.

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class HomeController{
	
	@Autowired
	private CourseService courseService;
	
//	@GetMapping("/")
//	public String home() {
//		return "hello world";
//	}
	
	@GetMapping("/course")
	public List<CourseInfo> getCourses(){
		return courseService.getCourse();
	}
	
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {
			 courseService.deleteCourse(courseId);
			 return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@PostMapping("/course")
	public CourseInfo addCourse(@RequestBody CourseInfo courseInfo) throws JsonProcessingException{
		
//		String jsonCourseInfo = JsonUtil.convertJavaToJson(courseInfo);
//		
//		CourseInfo courseInfo1 = JsonUtil.convertJsonToJava(jsonCourseInfo, CourseInfo.class);
		//System.out.println(courseInfo);
		return courseService.addCourse(courseInfo);
	}
	
	@PutMapping("/update")
	public CourseInfo updateCourse(@RequestBody CourseInfo courseInfo) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		
		return courseService.updateCourse(courseInfo);
	}

//	@RequestMapping("/error")
//	public String handleError(HttpServletResponse response) {
//
//		if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
//			return "./error/error400";
//		}
//		else if(response.getStatus() == HttpStatus.FORBIDDEN.value()) {
//			return "./error/error403";
//		}
//		else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//			return "./error/error500";
//		}
//		else {
//			return "./error/error";
//		}
//
//	}
//
//	@Override
//	public String getErrorPath() {
//		return "/error";
//	}
	
//	@PostMapping("/covid")
//	public List<CourseInfo> getCovid(){
//		return courseService.getCourse();
//	}
}
