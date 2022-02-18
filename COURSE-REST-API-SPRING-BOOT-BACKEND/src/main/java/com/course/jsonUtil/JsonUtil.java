package com.course.jsonUtil;

import java.io.IOException;

import com.course.model.CourseInfo;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}

	public static String convertJavaToJson(Object object) throws JsonProcessingException {
		
		String jsonResult = "";
		
		try {
		jsonResult = mapper.writeValueAsString(object);
		}catch(JsonGenerationException e) {
			System.out.println("Exception Occur When Convert Java Object To Json"+e.getMessage());
		}
         catch(JsonMappingException e) {
        	 System.out.println("Exception Occur When Convert Java Object To Json"+e.getMessage());
		}
         catch(IOException e) {
        	 System.out.println("Exception Occur When Convert Java Object To Json"+e.getMessage());
		}
		
		return jsonResult; 
		
	}
	
	
//	public static <T> T convertJsonToJava(String jsonString, Class<T> cls) {
//		
//		T javaResult = null;
//		
//		try {
//		 javaResult = mapper.readValue(jsonString, cls);
//		}catch(JsonParseException e) {
//			System.out.println("Exception Occur When Convert Json Object To Java"+e.getMessage());
//		}catch(JsonMappingException e) {
//       	 System.out.println("Exception Occur When Convert Json Object To Java"+e.getMessage());
//		}
//        catch(IOException e) {
//       	 System.out.println("Exception Occur When Convert Json Object To Java"+e.getMessage());
//		}
//		
//		return javaResult;
//	}


	public static CourseInfo convertJsonToJava(String jsonCourseInfo, Class<CourseInfo> cls) {
		CourseInfo javaResult = null;
		
		try {
		 javaResult = mapper.readValue(jsonCourseInfo, cls);
		}catch(JsonParseException e) {
			System.out.println("Exception Occur When Convert Json Object To Java"+e.getMessage());
		}catch(JsonMappingException e) {
       	 System.out.println("Exception Occur When Convert Json Object To Java"+e.getMessage());
		}
        catch(IOException e) {
       	 System.out.println("Exception Occur When Convert Json Object To Java"+e.getMessage());
		}
		
		return javaResult;
	}
}
