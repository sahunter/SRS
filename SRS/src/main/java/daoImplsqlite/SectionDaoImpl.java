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
import java.util.Map.Entry;
import java.util.Set;

import dao.SectionDao;
import daoImplsqlite.PersonDaoImpl;
import model.Course;
import model.Professor;
import model.Section;
import model.Student;
import model.TranscriptEntry;
import model.User;
import util.DBUtil;

public class SectionDaoImpl implements SectionDao{

	
	@Override
    public HashMap<String, Section> findAllsection() {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> sections = new HashMap<String, Section>();
		HashMap<String, Course> allCourses = new CourseDaoImpl().findAll();
		String sql = "select * from Section ,ScheduleOfClasses where FullSectionNo=sectionID  ";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
						
							Set<HashMap.Entry<String, Course>> set=allCourses.entrySet();    
						       for (Iterator<Entry<String, Course>> iterator = set.iterator(); iterator.hasNext();) {  
						    	   HashMap.Entry<String, Course> entry = (HashMap.Entry<String, Course>) iterator.next();  
						            String key=entry.getKey();  
					                Course value=entry.getValue(); 
					                if(rs.getString("representedCourse").equals(key)){
					                	  Section sec;
											sec = new Section(rs.getInt("sectionNo"),rs.getString("dayOfWeek").charAt(0), rs.getString("timeOfDay"), value ,rs.getString("room"),rs.getInt("seatingCapacity"));
					                        sections.put(rs.getString("FullSectionNo"), sec);
					                }	
					                }
                      
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
			return sections;
	}
	@Override
	public HashMap<String, Section> findBySemester(String semester) {
		// 根据semester获取相应的section数据,此处直接手动给出section数据
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> sections = new HashMap<String, Section>();
		HashMap<String, Course> allCourses = new CourseDaoImpl().findAll();
		String sql = "select * from Section ,ScheduleOfClasses where  semester=? and FullSectionNo=sectionID";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1,semester);
			rs = pstmt.executeQuery();
		
						while(rs.next()){
							          Set<HashMap.Entry<String, Course>> set=allCourses.entrySet();    
						                 for (Iterator<Entry<String, Course>> iterator = set.iterator(); iterator.hasNext();) {  
						                	 HashMap.Entry<String, Course> entry = (HashMap.Entry<String, Course>) iterator.next();  
						                       String key=entry.getKey();  
					                            Course value=entry.getValue(); 
					                            if(rs.getString("representedCourse").equals(key)){
					                	        Section sec;
											    sec = new Section(rs.getInt("sectionNo"),rs.getString("dayOfWeek").charAt(0), rs.getString("timeOfDay"), value ,rs.getString("room"),rs.getInt("seatingCapacity"));
					                            sections.put(value.getCourseNo() + "-" + sec.getSectionNo(), sec);
					                }
					                }
                         }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  if(rs != null){
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
			return sections;
	}
	
	@Override
    public HashMap<String, Section> findsection() {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> sections = new HashMap<String, Section>();
		HashMap<String, Course> allCourses = new CourseDaoImpl().findAll();
		String sql = "select * from Section,ScheduleOfClasses where FullSectionNo=sectionID  ";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
						
							Set<HashMap.Entry<String, Course>> set=allCourses.entrySet();    
						       for (Iterator<Entry<String, Course>> iterator = set.iterator(); iterator.hasNext();) {  
						    	   HashMap.Entry<String, Course> entry = (HashMap.Entry<String, Course>) iterator.next();  
						            String key=entry.getKey();  
					                Course value=entry.getValue(); 
					                if(rs.getString("representedCourse").equals(key)){
					                	  Section sec;
											sec = new Section(rs.getInt("sectionNo"),rs.getString("dayOfWeek").charAt(0), rs.getString("timeOfDay"), value ,rs.getString("room"),rs.getInt("seatingCapacity"));
					                        sections.put(rs.getString("FullSectionNo")+ "-" + rs.getString("semester"), sec);
					                }	
					                }
                      
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
			return sections;
	}

	
	@Override
	public void updateProfessorSectionServlet(String fullSectionNo,String professor) {
		// TODO Auto-generated method stub
		
		Connection Conn = DBUtil.getSqliteConnection();
		
		String sql ="update Section set professor=?  WHERE  FullSectionNo=?";
		PreparedStatement stmt = null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    try {
	    	stmt.setString(1, professor);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    	stmt.setString(2, fullSectionNo);
			
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
	public void addSection(String fullSectionNo,Section section,String  representedCourse) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "INSERT INTO Section(FullSectionNo,sectionNo,dayOfWeek,timeOfDay,room,seatingCapacity,representedCourse) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement stmt=null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
	    	stmt.setString(1, fullSectionNo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		    	stmt.setInt(2, section.getSectionNo());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(3, String.valueOf(section.getDayOfWeek()));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(4, String.valueOf(section.getTimeOfDay()));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(5, section.getRoom());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setInt(6, section.getSeatingCapacity());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		    try {
		    	stmt.setString(7, representedCourse);
				
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
	public void updateSection(String fullSectionNo,Section section,	String representedCourse) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "update Section set FullSectionNo=?,sectionNo=?,dayOfWeek=?,timeOfDay=?,room=?,seatingCapacity=?,representedCourse=? where sectionNo=?";
		PreparedStatement stmt=null;
		try {
			stmt = Conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
	    	stmt.setString(1, fullSectionNo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		    	stmt.setInt(2, section.getSectionNo());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(3, String.valueOf(section.getDayOfWeek()));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(4, String.valueOf(section.getTimeOfDay()));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setString(5, section.getRoom());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		    	stmt.setInt(6, section.getSeatingCapacity());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		    try {
		    	stmt.setString(7, representedCourse);
				
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
	public void deleteSection(String FullSectionNo) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "DELETE FROM Section WHERE FullSectionNo=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		//	pstmt.setString(1, user.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		    	pstmt.setString(1, FullSectionNo);
				
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
	public HashMap<String, Section> findByName(User user) {
		// 根据semester获取相应的section数据,此处直接手动给出section数据
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> sections = new HashMap<String, Section>();
		HashMap<String, Course> allCourses = new CourseDaoImpl().findAll();
		String sql = "select * from Section ,Transcript where  name=? and FullSectionNo=sectionID";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserName());
			rs = pstmt.executeQuery();
		
						while(rs.next()){
							          Set<HashMap.Entry<String, Course>> set=allCourses.entrySet();    
						                 for (Iterator<Entry<String, Course>> iterator = set.iterator(); iterator.hasNext();) {  
						                	 HashMap.Entry<String, Course> entry = (HashMap.Entry<String, Course>) iterator.next();  
						                       String key=entry.getKey();  
					                            Course value=entry.getValue(); 
					                            if(rs.getString("representedCourse").equals(key)){
					                	        Section sec;
											    sec = new Section(rs.getInt("sectionNo"),rs.getString("dayOfWeek").charAt(0), rs.getString("timeOfDay"), value ,rs.getString("room"),rs.getInt("seatingCapacity"));
					                            sections.put(value.getCourseNo() + "-" + sec.getSectionNo(), sec);
					                }
					                }
                         }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  if(rs != null){
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
			return sections;
	}
	public Section findselectsection(String semester,String select) {
		HashMap<String, Section> sections = new SectionDaoImpl().findBySemester(semester);
		 Set<HashMap.Entry<String, Section>> set=sections.entrySet();    
			Section selectsection = new Section(0, (char) 0, null, null, null, 0);
			for (Iterator<Entry<String, Section>> iterator = set.iterator(); iterator.hasNext();) {  
				HashMap.Entry<String, Section> entry = (HashMap.Entry<String, Section>) iterator.next();  
		            String key=entry.getKey();  
		            Section value=entry.getValue(); 
		            if(select.equals(key)){
		            		selectsection= value;
		            }
		}
			return selectsection;
	}
	@Override
	public HashMap<String, Section> findsectionByProfessor(User user) {
		// TODO Auto-generated method stub
		
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> sections = new HashMap<String, Section>();
		HashMap<String, Course> allCourses = new CourseDaoImpl().findAll();
		String sql = "select * from Section  where  professor=? ";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserName());
			rs = pstmt.executeQuery();
		
						while(rs.next()){
							          Set<HashMap.Entry<String, Course>> set=allCourses.entrySet();    
						                 for (Iterator<Entry<String, Course>> iterator = set.iterator(); iterator.hasNext();) {  
						                	 HashMap.Entry<String, Course> entry = (HashMap.Entry<String, Course>) iterator.next();  
						                       String key=entry.getKey();  
					                            Course value=entry.getValue(); 
					                            if(rs.getString("representedCourse").equals(key)){
					                	        Section sec;
											    sec = new Section(rs.getInt("sectionNo"),rs.getString("dayOfWeek").charAt(0), rs.getString("timeOfDay"), value ,rs.getString("room"),rs.getInt("seatingCapacity"));
					                            sections.put(value.getCourseNo() + "-" + sec.getSectionNo(), sec);
					                }
					                }
                         }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  if(rs != null){
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
			return sections;
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
