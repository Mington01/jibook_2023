package ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch09.Student;

public class NewsDAO {
	
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";
	
	//DB 연결을 가져오는 메서
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "jwbook", "1234");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void addNews(News n) throws Exception {
		Connection conn = open();
		
		String sql = "INSERT INTO news(title, img, date, content) values(?, ?, CURRENT_TIMESTAMP(), ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  s.getUsername());
			pstmt.setString(2,  s.getUniv());
			pstmt.setDate(3,  s.getBirth());
			pstmt.setString(4,  s.getEmail());
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public List<Student> getAll() {
		open();
		List<Student> students = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select * from student");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				
				s.setId((rs.getInt("id")));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				students.add(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
		return students;
	}
}
