package me.minikuma.dao;

import me.minikuma.connection.ConnectionManager;
import me.minikuma.domain.User;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
    public void executeUpdate(String sql, PreparedStatementSetter ps) throws SQLException {
        // TODO: JDBC Connection
        Connection con = null;
        PreparedStatement psmt = null;

        try {
            con = ConnectionManager.getConnection();
            psmt = con.prepareStatement(sql);
            ps.setValues(psmt);
            psmt.executeUpdate();
        }  finally {
            if (psmt != null) {
                psmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }

    public User executeQuery(String sql, PreparedStatementSetter ps, RowMapper<User> rowMapper) throws SQLException {
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = ConnectionManager.getConnection();
            psmt = con.prepareStatement(sql);
            ps.setValues(psmt);
            rs = psmt.executeQuery();
            if (rs.next()) {
                return rowMapper.map(rs);
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
