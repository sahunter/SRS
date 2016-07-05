package daoImplsqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.ScheduleDao;
import model.Course;
import model.ScheduleOfClasses;
import model.Section;
import util.DBUtil;

public class ScheduleDaoImpl implements ScheduleDao {

	@Override
	public ScheduleOfClasses getScheduleOfClass(String semester) {
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> allsections = new SectionDaoImpl().findBySemester(semester);
		String sql = "select * from ScheduleOfClasses ";
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
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				
	
		
		return null;
	}
	
	}

