package daoImplsqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import dao.PersonDao;
import model.Course;
import model.Professor;
import model.Section;
import model.Student;
import model.Transcript;
import model.TranscriptEntry;
import model.User;
import util.DBUtil;

public class PersonDaoImpl implements PersonDao {


	@Override
	public HashMap<String, Professor> findAllProfessors() {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Professor> professors = new HashMap<String, Professor>();
	//	User user = new UserDaoImpl().getUser(user);
		String sql = "select ssn,name ,title, department from Person where type='Professor'";
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
		try {
			while(rs.next()){
			Professor professor;
			professor = new Professor(rs.getString("name"), rs.getString("ssn"),rs.getString("title"), rs.getString("department"));
			professors.put(professor.getSsn(), professor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(rs != null){
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
		
		
		return professors;
	}

	@Override
	public HashMap<String, Student> findAllStudents() {
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Student> students = new HashMap<String, Student>();
		String sql = "select ssn,name ,major, degree from Person where type='Student'";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
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
		try {
			while(rs.next()){
			Student student;
			student = new Student(rs.getString("name"), rs.getString("ssn"),rs.getString("major"), rs.getString("degree"));
			students.put(student.getSsn(), student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(rs != null){
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
		
		
		return students;
	}	

	@Override
	public Student  getLoginStuent(User user){
	
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Student> students = new PersonDaoImpl().findAllStudents();
		HashMap<String, TranscriptEntry> Totaltranscript = new TranscriptDaoImpl().getTranscript();
		 Set<HashMap.Entry<String, Student>> set=students.entrySet();    
			Student loginstudent = new Student(null, null, null, null);
			for (Iterator<Entry<String, Student>> iterator = set.iterator(); iterator.hasNext();) {  
				HashMap.Entry<String, Student> entry = (HashMap.Entry<String, Student>) iterator.next();  
		            Student value=entry.getValue(); 
		            if(user.getUserName().equals(value.getName())){
	                    loginstudent= value;
	                 //   Transcript	tr = new Transcript(null);
	                    Transcript	transcript = new Transcript(loginstudent);
	                    Set<HashMap.Entry<String, TranscriptEntry>> set1=Totaltranscript.entrySet();    	
						for (Iterator<Entry<String, TranscriptEntry>> iterator1 = set1.iterator(); iterator1.hasNext();) {  
					    	   HashMap.Entry<String, TranscriptEntry> entry1 = (HashMap.Entry<String, TranscriptEntry>) iterator1.next();  
					      
					    	   TranscriptEntry value1=entry1.getValue();
					         /*   TranscriptEntry transcriptentry = new TranscriptEntry(null, null, null);
        		            	transcriptentry.setTranscript(value1);*/
					          //  Student StudentOwner = new Student(null, null, null, null);
					            Student StudentOwner = value1.getStudent();
	        		            if(loginstudent.getName()==StudentOwner.getName()){
									transcript.addTranscriptEntry(value1);
	        		            //	tr=value1;
								//	loginstudent.setTranscript(tr);
	        		            }
	        		            }
						loginstudent.setTranscript(transcript);
		            }
		}
			return loginstudent;
	}	
		
	
}
