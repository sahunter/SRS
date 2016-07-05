package daoImplsqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import model.Student;
import model.User;
import util.DBUtil;

public class UserDaoImpl implements UserDao{


	public User getUser(User user) {
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "SELECT * FROM User WHERE username=?";
		PreparedStatement pstmt=null;
			try {
				pstmt = Conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.setString(1,user.getUserName());
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
					user=new User();
					user.setUserName(rs.getString("username"));
					user.setPassWord(rs.getString("password"));	
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
			return user;
	}

	

	
}
