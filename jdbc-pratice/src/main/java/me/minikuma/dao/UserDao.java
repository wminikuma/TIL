package me.minikuma.dao;

import me.minikuma.connection.ConnectionManager;
import me.minikuma.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    // 생성
    public void create(User user) throws SQLException {
        // TODO: JDBC Connection
        Connection con = null;
        PreparedStatement psmt = null;

        try {
            con = ConnectionManager.getDataSource().getConnection();
            String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, user.getUserId());
            psmt.setString(2, user.getPassword());
            psmt.setString(3, user.getName());
            psmt.setString(4, user.getEmail());
            psmt.executeUpdate();
        } catch (SQLException e) {

        } finally {
            if (psmt != null) {
                psmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }


    // 아이디 기준 단건 조회
    public User findById(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = ConnectionManager.getDataSource().getConnection();
            String sql = "SELECT * FROM USERS WHERE userId = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, userId);
            rs = psmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            throw new SQLException("SQL Error!");
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (psmt != null) {
                psmt.close();
            }

            if (con != null) {
                con.close();
            }
        }

        return user;
    }
}
