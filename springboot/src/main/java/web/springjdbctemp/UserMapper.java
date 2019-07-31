package web.springjdbctemp;

import org.springframework.jdbc.core.RowMapper;
import web.bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException{
        User user = new User();
        user.setName(resultSet.getString("NAME"));
        user.setPassword(resultSet.getString("PASSWORD"));
        return user;
    }
}
