package me.minikuma.dao;

import me.minikuma.domain.User;

import java.sql.SQLException;

public class UserDao {

    // 생성
    public void create(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(sql, ps -> {
            ps.setString(1, user.getUserId());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail());
        });
    }

    public User findById(String userId) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT * FROM USERS WHERE userId = ?";
        return jdbcTemplate.executeQuery(sql, ps -> ps.setString(1, userId),
                rs -> new User(
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("email")
        ));
    }
}
