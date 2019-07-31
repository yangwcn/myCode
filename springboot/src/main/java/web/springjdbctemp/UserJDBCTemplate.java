package web.springjdbctemp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import web.bean.User;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public UserJDBCTemplate(@Autowired DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getAllUser() {
        String sql = "select * from user";
        List<User> allUser = jdbcTemplate.query(sql,new UserMapper());
        return allUser;
    }
}
