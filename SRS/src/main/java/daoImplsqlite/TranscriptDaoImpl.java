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

import dao.SectionDao;
import dao.TranscriptDao;
import model.Course;

import model.Section;
import model.Student;
import model.Transcript;
import model.TranscriptEntry;
import model.User;
import util.DBUtil;

public class TranscriptDaoImpl implements TranscriptDao{

	/*@Override
	public ArrayList<TranscriptEntry> findTranscript() {
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();
	//	HashMap<String, TranscriptEntry> transcript = new HashMap<String, TranscriptEntry>();
		HashMap<String, Section> sections = new SectionDaoImpl().findAllsection();
		HashMap<String, Student> students = new PersonDaoImpl().findAllStudents();
		ArrayList<TranscriptEntry> transcriptEntries = new ArrayList<TranscriptEntry>();
		String sql = "select * from Transcript";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	  
	                Transcript transcript = new Transcript(null);
					try {
						while(rs.next()){
							Set<HashMap.Entry<String, Section>> set=sections.entrySet();    
						       for (Iterator<Entry<String, Section>> iterator = set.iterator(); iterator.hasNext();) {  
						    	   HashMap.Entry<String, Section> entry = (HashMap.Entry<String, Section>) iterator.next();  
						            String key=entry.getKey();  
						            Section value=entry.getValue(); 
					                if(rs.getString("sectionID").equals(key)){
					                	Set<HashMap.Entry<String, Student>> set1=students.entrySet();    
									       for (Iterator<Entry<String, Student>> iterator1 = set1.iterator(); iterator.hasNext();) {  
									    	   HashMap.Entry<String, Student> entry1 = (HashMap.Entry<String, Student>) iterator1.next();  
									            String key1=entry1.getKey();  
									            Student value1=entry1.getValue(); 
								                if(rs.getString("name").equals(value1.getName())){
								                	 TranscriptEntry transcriptentry;
								                	 transcriptentry = new TranscriptEntry( value1,rs.getString("grade"),value);
								                	  transcriptEntries = transcript.addTranscriptEntry(transcriptentry);    
								                }
					                }
						
					                }}}
	                     }catch (SQLException e) {
		                      // TODO Auto-generated catch block
	                       	e.printStackTrace();
	                    }  if(rs != null){
	                          	try {
		                        	rs.close();
		                                } catch (SQLException e) {
			// TODO Auto-generated catch block
			                          e.printStackTrace();
		                                   }
                                     	}try {
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
						       return transcriptEntries;
	                }*/
	@Override
	public HashMap<String,TranscriptEntry> getTranscript(){
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, TranscriptEntry> Totaltranscript = new HashMap<String, TranscriptEntry>();
	//	HashMap<String, TranscriptEntry> transcript = new HashMap<String, TranscriptEntry>();
		HashMap<String, Section> sections = new SectionDaoImpl().findAllsection();
		HashMap<String, Student> students = new PersonDaoImpl().findAllStudents();
		String sql = "select * from Transcript";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e1)	 {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	  
					try {
						while(rs.next()){
							Set<HashMap.Entry<String, Student>> set1=students.entrySet();    	
							for (Iterator<Entry<String, Student>> iterator1 = set1.iterator(); iterator1.hasNext();) {  
						    	   HashMap.Entry<String, Student> entry1 = (HashMap.Entry<String, Student>) iterator1.next();  
						            //String key1=entry1.getKey();  
						            Student value1=entry1.getValue(); 
					                if(rs.getString("name").equals(value1.getName())){
					                Transcript transcript = new Transcript(null);
						           	Set<HashMap.Entry<String, Section>> set=sections.entrySet();    
						           for (Iterator<Entry<String, Section>> iterator11 = set.iterator(); iterator11.hasNext();) {  
						    	   HashMap.Entry<String, Section> entry = (HashMap.Entry<String, Section>) iterator11.next();  
						            String key=entry.getKey();  
						            Section value=entry.getValue(); 
					                if(rs.getString("sectionID").equals(key)){
								                	 TranscriptEntry transcriptentry;
								                	 transcriptentry = new TranscriptEntry( value1,rs.getString("grade"),value);
								                	// transcript.addTranscriptEntry(transcriptentry);    
								                	 Totaltranscript.put(value1.getName() + "-" + rs.getString("sectionID"), transcriptentry);	
								                	 
								                }
					                }
						          
		                            
					                }
					                
							}}
	                     }catch (SQLException e) {
		                      // TODO Auto-generated catch block
	                       	e.printStackTrace();
	                    }  if(rs != null){
	                          	try {
		                        	rs.close();
		                                } catch (SQLException e) {
			// TODO Auto-generated catch block
			                          e.printStackTrace();
		                                   }
                                     	}try {
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
						       return Totaltranscript;
	                }

	
	@Override
	public void addTranscript(TranscriptEntry transcriptentry) {
		// TODO Auto-generated method stub
		
		Connection Conn = DBUtil.getSqliteConnection();
		Student  student=transcriptentry.getStudent();
		Section  section=transcriptentry.getSection();
		String sql = "INSERT INTO Transcript(name,sectionID,grade) VALUES(?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    try {
	    	stmt.setString(1, student.getName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    	stmt.setString(2,transcriptentry.getGrade());
	    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    	stmt.setString(3,section.getFullSectionNo());
	    
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
	public HashMap<String, TranscriptEntry> findTranscriptByStudent(User user) {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, TranscriptEntry> Totaltranscript = new TranscriptDaoImpl().getTranscript();
		HashMap<String, TranscriptEntry> personnaltrancript=new HashMap<String, TranscriptEntry>();
		
	                    Set<HashMap.Entry<String, TranscriptEntry>> set1=Totaltranscript.entrySet();    	
						for (Iterator<Entry<String, TranscriptEntry>> iterator1 = set1.iterator(); iterator1.hasNext();) {  
					    	   HashMap.Entry<String, TranscriptEntry> entry1 = (HashMap.Entry<String, TranscriptEntry>) iterator1.next();  
					            String key1=entry1.getKey();  
					            TranscriptEntry value1=entry1.getValue(); 	
					       Student  StudentOwner  = value1.getStudent();
	        		            if(user.getUserName().equals(StudentOwner.getName())){
	        		            	/*TranscriptEntry transcriptentry = new TranscriptEntry(null, null, null);
	        		            	transcriptentry.setTranscript(value1);*/
	        		            	Section section;
	        		            	 section=value1.getSection();
	        		            	personnaltrancript.put(user.getUserName()+ "-" + section.getFullSectionNo(), value1);	 	
	        		            }
	        		            }
			return personnaltrancript;
	}	
		// TODO Auto-generated method stub
	@Override
	public HashMap<String, TranscriptEntry> findEnrollcourseByStudent(User user) {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, TranscriptEntry> personnaltrancript = new TranscriptDaoImpl().findTranscriptByStudent(user);
		HashMap<String, TranscriptEntry> enrollcourse=new HashMap<String, TranscriptEntry>();
		 Set<HashMap.Entry<String, TranscriptEntry>> set1=personnaltrancript.entrySet();    	
			for (Iterator<Entry<String, TranscriptEntry>> iterator1 = set1.iterator(); iterator1.hasNext();) {  
		    	   HashMap.Entry<String, TranscriptEntry> entry1 = (HashMap.Entry<String, TranscriptEntry>) iterator1.next();  
		            TranscriptEntry value1=entry1.getValue(); 
		           /* TranscriptEntry transcriptentry = new TranscriptEntry(null, null, null);
	            	transcriptentry.setTranscript(value1);*/
		            if(value1.getGrade()==""){
		            	Section section;
		            	 section=value1.getSection();
		            	 enrollcourse.put(user.getUserName()+ "-" + section.getFullSectionNo(), value1);	 	
		            }
		
		            }
		
		return enrollcourse;
	}
	@Override
	public void deleteTranscript(String name,String FullSectoinNo) {
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();	
		String sql = "DELETE FROM Transcript WHERE name=? and sectionID=?  ";
		PreparedStatement stmt = null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
	//	 GuitarSpec spec = guitar.getSpec();
	    try {
			stmt.setString(1, name);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			stmt.setString(2, FullSectoinNo);
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
	public HashMap<String, TranscriptEntry> searchTranscript(User user) {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, TranscriptEntry> personnaltrancript = new TranscriptDaoImpl().findTranscriptByStudent(user);
		HashMap<String, TranscriptEntry> transcript=new HashMap<String, TranscriptEntry>();
		 Set<HashMap.Entry<String, TranscriptEntry>> set1=personnaltrancript.entrySet();    	
			for (Iterator<Entry<String, TranscriptEntry>> iterator1 = set1.iterator(); iterator1.hasNext();) {  
		    	   HashMap.Entry<String, TranscriptEntry> entry1 = (HashMap.Entry<String, TranscriptEntry>) iterator1.next();  
		            TranscriptEntry value1=entry1.getValue(); 
		           /* TranscriptEntry transcriptentry = new TranscriptEntry(null, null, null);
	            	transcriptentry.setTranscript(value1);*/
		            if(value1.getGrade()!=""&&value1.getGrade()!=null){
		            	Section section;
		            	 section=value1.getSection();
		            	 transcript.put(user.getUserName()+ "-" + section.getFullSectionNo(), value1);	 	
		            }
		
		            }
		
		return transcript;
	}

	@Override
	public HashMap<String, TranscriptEntry> searchTranscriptByProfessor(User user) {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, TranscriptEntry> personnaltrancript = new TranscriptDaoImpl().getTranscript();
		HashMap<String, Section> professorsection=new  SectionDaoImpl().findsectionByProfessor( user);
		HashMap<String, TranscriptEntry> transcript=new HashMap<String, TranscriptEntry>();
		 Set<HashMap.Entry<String, TranscriptEntry>> set1=personnaltrancript.entrySet();    	
			for (Iterator<Entry<String, TranscriptEntry>> iterator1 = set1.iterator(); iterator1.hasNext();) {  
		    	   HashMap.Entry<String, TranscriptEntry> entry1 = (HashMap.Entry<String, TranscriptEntry>) iterator1.next();  
		            TranscriptEntry value1=entry1.getValue(); 
		           /* TranscriptEntry transcriptentry = new TranscriptEntry(null, null, null);
	            	transcriptentry.setTranscript(value1);*/
		            Set<HashMap.Entry<String, TranscriptEntry>> set=personnaltrancript.entrySet();    	
					for (Iterator<Entry<String, TranscriptEntry>> iterator = set1.iterator(); iterator1.hasNext();) {  
				    	   HashMap.Entry<String, TranscriptEntry> entry = (HashMap.Entry<String, TranscriptEntry>) iterator1.next();  
				            TranscriptEntry value=entry1.getValue(); 
		            if(value1.getSection().equals(value)){
		            	Section section;
		            	 section=value1.getSection();
		            	 transcript.put(user.getUserName()+ "-" + section.getFullSectionNo(), value1);	 	
		            }
		
		            }
		
		
	}

			return transcript;
}
	@Override
	public void updateTranscript(String sectionID, String grade) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "update Transcript set grade=? where  sectionID=?";
		PreparedStatement stmt=null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    try {
		    	stmt.setString(1, grade);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(2, sectionID);
				
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

}
