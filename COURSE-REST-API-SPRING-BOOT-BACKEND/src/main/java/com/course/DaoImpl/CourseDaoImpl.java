package com.course.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.course.Dao.CourseDao;
import com.course.conn.DataBaseConnection;
import com.course.model.CourseInfo;





@Component("CourseDao")
public class CourseDaoImpl implements CourseDao{
	
	@Override
	public List<CourseInfo> getCourse(){
		
		List<CourseInfo> ci = new ArrayList<CourseInfo>();
        String query = "select id, course_name, course_discription from coursedata where isActive = ?";
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				CourseInfo data=new CourseInfo();
				
				data.setId(rs.getString("id"));
				data.setCourseName(rs.getString("course_name"));
				data.setCourseDiscription(rs.getString("course_discription"));
				
				ci.add(data);
			}
			

		}  catch (SQLException e) {
			e.printStackTrace();
		} 
        catch (Exception e) {

			e.printStackTrace();
			
		}
		finally{
			DataBaseConnection.close(ps);
			DataBaseConnection.close(rs);
			DataBaseConnection.close(con);
		}
        
        
          return ci;
		
	}

	
	@Override
	public boolean deleteCourse(String courseId) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		StringBuffer sb = new StringBuffer();
		 
//		 String pattern = "dd-MM-yyyy";
//		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		 String date = simpleDateFormat.format(new Date());
//		 
//		 
//		 Date time = new Date();
//	      String strDateFormat = "HH:mm:ss a";
//	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
//	      
//		 
	      
	      
		  sb.append(" UPDATE coursedata ")
			.append("SET isActive = ? WHERE id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnection.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setBoolean(1, false);
				ps.setString(2, courseId);

              int i=ps.executeUpdate();  
				System.out.println(i+" records Daleted");  
				DataBaseConnection.commit(con);
				
	        } catch (SQLException e) {
				e.printStackTrace();
	        }
			finally{
				DataBaseConnection.close(ps);
				DataBaseConnection.close(con);
			}
	        
	        return true;
			
		
	}
	
	
	public CourseInfo addCourse(CourseInfo courseInfo) {
		
		
	 StringBuffer sb = new StringBuffer();
		 
//		 String pattern = "dd-MM-yyyy";
//		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		 String date = simpleDateFormat.format(new Date());
//		 
//		 
//		 Date time = new Date();
//	      String strDateFormat = "HH:mm:ss a";
//	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
//	      
//		 
	      
	      
		  sb.append(" INSERT INTO coursedata  ")
			.append("( id, course_name, course_discription, isActive)")
			.append(" VALUES(?, ?, ?, ?) ");
	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnection.getConnection();
				ps = con.prepareStatement(sb.toString());
				
               ps.setString(1, courseInfo.getId());
               ps.setString(2, courseInfo.getCourseName());
               ps.setString(3, courseInfo.getCourseDiscription());
               ps.setBoolean(4, true);
              
         	  
               int i=ps.executeUpdate();  
				System.out.println(i+" records inserted");  
				DataBaseConnection.commit(con);
				
	        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
	        }
			finally{
				DataBaseConnection.close(ps);
				DataBaseConnection.close(con);
			}
	        
	        return courseInfo;
		
	}
	
	
	
	@Override
	public CourseInfo updateCourse(CourseInfo courseInfo) throws ClassNotFoundException, InstantiationException, IllegalAccessException  {
		 StringBuffer sb = new StringBuffer();
		 
//		 String pattern = "dd-MM-yyyy";
//		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		 String date = simpleDateFormat.format(new Date());
//		 
//		 
//		 Date time = new Date();
//	      String strDateFormat = "HH:mm:ss a";
//	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
//	      
//		 
	      
	      
		  sb.append(" UPDATE coursedata ")
			.append("SET course_name = ? , course_discription = ? WHERE id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnection.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setString(1, courseInfo.getCourseName());
				ps.setString(2, courseInfo.getCourseDiscription());
				ps.setString(3, courseInfo.getId());
               int i=ps.executeUpdate();  
				System.out.println(i+" records Updated");  
				DataBaseConnection.commit(con);
				
	        } catch (SQLException e) {
				e.printStackTrace();
	        }
			finally{
				DataBaseConnection.close(ps);
				DataBaseConnection.close(con);
			}
	        
	        return courseInfo;
	}

}
