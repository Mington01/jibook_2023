package guestBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestBookDAO {

    public List<GuestbookModel> getAll() {
        List<GuestbookModel> guestbooks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM guestbook";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                GuestbookModel guestbook = new GuestbookModel();
                guestbook.setId(rs.getInt("id"));
                guestbook.setAuthor(rs.getString("author"));
                guestbook.setEmail(rs.getString("email"));
                guestbook.setTitle(rs.getString("title"));
                guestbook.setgPassword(rs.getString("gPassword"));
                guestbook.setContent(rs.getString("content"));
                guestbook.setCreatedAt(rs.getDate("createdAt"));

                guestbooks.add(guestbook);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 출력
        } finally {
            DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }
        
        return guestbooks;
    }
    
    public void insert(GuestbookModel guestbook) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "INSERT INTO guestbook (author, email, title, gPassword, content, createdAt) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP())";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guestbook.getAuthor());
            pstmt.setString(2, guestbook.getEmail());
            pstmt.setString(3, guestbook.getTitle());
            pstmt.setString(4, guestbook.getgPassword());
            pstmt.setString(5, guestbook.getContent());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }
    }
    
    public GuestbookModel getGuestbookById(int id) {
        GuestbookModel guestbook = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM guestbook WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                guestbook = new GuestbookModel();
                guestbook.setId(rs.getInt("id"));
                guestbook.setAuthor(rs.getString("author"));
                guestbook.setEmail(rs.getString("email"));
                guestbook.setTitle(rs.getString("title"));
                guestbook.setgPassword(rs.getString("gPassword"));
                guestbook.setContent(rs.getString("content"));
                guestbook.setCreatedAt(rs.getDate("createdAt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }

        return guestbook;
    }
    
//    업데이트기

//    public GuestbookModel update(GuestbookModel guestbook) {
    public Boolean update(GuestbookModel guestbook) {  
    	Connection conn = null;
        PreparedStatement pstmt = null;
        Boolean result = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "UPDATE guestbook SET author=?, email=?, title=?, gPassword=?, content=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guestbook.getAuthor());
            pstmt.setString(2, guestbook.getEmail());
            pstmt.setString(3, guestbook.getTitle());
            pstmt.setString(4, guestbook.getgPassword());
            pstmt.setString(5, guestbook.getContent());
            pstmt.setInt(6, guestbook.getId());

            pstmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
        	result = false;
            e.printStackTrace();
        } finally {
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }
        
        return result;
    }
}