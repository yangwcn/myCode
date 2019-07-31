package web.springjdbctemp;

import org.springframework.jdbc.core.JdbcTemplate;
import web.bean.User;

import javax.sql.DataSource;
import java.util.List;

public class UserJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getAllUser() {
        String sql = "select * from user";
        List<User> allUser = jdbcTemplate.query(sql,new UserMapper());
        return allUser;
    }
}
