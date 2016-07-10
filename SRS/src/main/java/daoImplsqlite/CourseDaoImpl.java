package daoImplsqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import dao.CourseDao;
import model.Course;
import model.CourseCatalog;
import model.Professor;
import util.DBUtil;

public class CourseDaoImpl implements CourseDao {
	
	@Override
	public HashMap<String,Course> findAll(){
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String,Course> courses = new HashMap<String, Course>();
		HashMap<String, Course> prerequisites = new CourseDaoImpl().findPrerequisite();
		String sql = "select * from Course";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 try {
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			try {
				while(rs.next()){
					Course course;
					course= new Course(rs.getString("courseNo"), rs.getString("courseName"), Double.valueOf(rs.getString("credits")));	
					Set<HashMap.Entry<String, Course>> set=prerequisites.entrySet();    
					for (Iterator<Entry<String, Course>> iterator = set.iterator(); iterator.hasNext();) {  
						HashMap.Entry<String, Course> entry = (HashMap.Entry<String, Course>) iterator.next();  
				            String key=entry.getKey();  
				            Course value=entry.getValue(); 
					   if(rs.getString("courseNo").equals(key)){
						   course.addPrerequisite(value);	
					   }
				       }
				       courses.put(course.getCourseNo(), course);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			
		return courses;
	}

	@Override
	public HashMap<String, Course> findPrerequisite() {
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String,Course> prerequisites = new HashMap<String, Course>();
		String sql= "select courseNo, courseName,credits,presentcourse from Course ,Prerequisite where courseNo=prerequisite";;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
		try {
			pstmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			 rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				Course  prerequisitecourse;
				prerequisitecourse=new Course(rs.getString("courseNo"), rs.getString("courseName"), Double.valueOf(rs.getString("credits")));
				prerequisites.put(rs.getString("presentcourse"), prerequisitecourse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prerequisites;
	}
/*	@Override
	public List<Course> searchCourse(Course course) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "select courseNo,courseName ,credits from Course ";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		//	pstmt.setString(1, user.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			while(rs.next()){
				course=new Course(null, null, 0);
				course.setCourseNo(rs.getString("courseNo"));
				course.setCourseName(rs.getString("courseName"));
				course.setCredits(Double.valueOf(rs.getString("credits")));
				courses.add(course);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return courses;
		}*/
	@Override
	public void addCourse(Course course) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "INSERT INTO Person(courseNo,courseName,credits) VALUES(?,?,?)";
		PreparedStatement stmt=null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		    	stmt.setString(1, course.getCourseNo());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(2, course.getCourseName());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(3, String.valueOf(course.getCredits()));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	@Override
	public void updateCourse(Course course) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "update Person set courseNo=?,courseName=?,credits=? where  courseNo=?";
		PreparedStatement stmt=null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    try {
		    	stmt.setString(1, course.getCourseNo());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(2, course.getCourseName());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
		    	stmt.setString(3, String.valueOf(course.getCredits()));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
		    	stmt.setString(4, course.getCourseNo());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	@Override
	public void deleteCourse(Course course) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "DELETE FROM Person WHERE courseNo=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		//	pstmt.setString(1, user.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		    	pstmt.setString(1, course.getCourseNo());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 try {
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	@Override
	public HashMap<String, Course> findPrerequisiteByCourse(String courseNo) {
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String,Course> prerequisites = new HashMap<String, Course>();
		String sql= "select courseNo, courseName,credits,presentcourse from Course ,Prerequisite where courseNo=prerequisite and presentcourse=?";;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
		try {
			pstmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		    	pstmt.setString(1, courseNo);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        try {
			 rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				Course  prerequisitecourse;
				prerequisitecourse=new Course(rs.getString("courseNo"), rs.getString("courseName"), Double.valueOf(rs.getString("credits")));
				prerequisites.put(rs.getString("presentcourse"), prerequisitecourse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prerequisites;
	}
	@Override
	public void addPrerequisite(String ID,String presentcourse,String  prerequisite) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "INSERT INTO Prerequisite(ID,presentcourse,prerequisite) VALUES(?,?,?)";
		PreparedStatement stmt=null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
	    	stmt.setString(1, ID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		    	stmt.setString(2, presentcourse);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(3, prerequisite);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	@Override
	public void updatePrerequisite(String ID,String presentcourse,String  prerequisite) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "update Prerequisite set ID=?,presentcourse=?,prerequisite=?where ID=?";
		PreparedStatement stmt=null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
	    	stmt.setString(1, ID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		    	stmt.setString(2, presentcourse);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(3, prerequisite);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	@Override
	public void deletePrerequisite(String ID, String presentcourse, String prerequisite1) {
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "DELETE FROM Prerequisite WHERE ID=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		//	pstmt.setString(1, user.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		    	pstmt.setString(1, ID);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 try {
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
	
/*	
	//String sql3= "select * from Course  where courseNo IN(select prerequisite from  Prerequisite where courseNo='"+i+"')";
	//	String sql2= "select * from Course ,Prerequisite where Course.courseNo=Prerequisite.prerequisite";
	//	pstmt2 = Conn.prepareStatement(sql2);
	//      rs2 = pstmt2.executeQuery();
		while(rs2.next()){
			Course  prerequisitecourse;
			prerequisitecourse=new Course(rs2.getString("courseNo"), rs2.getString("courseName"), rs2.getDouble("credits"));
			course.addPrerequisite(prerequisitecourse);
		}
*/