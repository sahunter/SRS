package testUtil;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import util.DBUtil;

public class DBUtilTest {

	@Test
	public void test(){		
		try {
			Connection Conn = DBUtil.getSqliteConnection();		
			String sql = "select count(*) from inventory";
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			assertEquals(rs.getInt(0), 4);
			Conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
