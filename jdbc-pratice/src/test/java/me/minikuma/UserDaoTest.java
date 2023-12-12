package me.minikuma;

import me.minikuma.connection.ConnectionManager;
import me.minikuma.dao.UserDao;
import me.minikuma.domain.User;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

class UserDaoTest {
    @BeforeEach
    void before() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    void createUserTest() throws SQLException {
        User user = new User("wizard", "password", "name", "email");
        UserDao userDao = new UserDao();
        userDao.create(user);
        User findUser = userDao.findById("wizard");
        Assertions.assertThat(findUser).isEqualTo(user);
    }
}
