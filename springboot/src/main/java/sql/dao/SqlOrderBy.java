package sql.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import web.bean.User;
import web.springjdbctemp.UserMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SqlOrderBy {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public SqlOrderBy(@Autowired DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<CityUser> getAllUser(String city) {
        String sql = "select city,`name`,age from tb_city_user where city = :city order by `name` desc limit 1000";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("city", city);
        List<CityUser> allUser = jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<CityUser>(CityUser.class));
        return allUser;
    }

    public List<CityUser> getAllUser(List<String> citys) {
        String sql = "select city,`name`,age from tb_city_user where city in (:city) order by `name` desc limit 1000";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("city", citys);
        List<CityUser> allUser = jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<CityUser>(CityUser.class));
        return allUser;
    }

    public List<SimpleCityUser> getSimple(String city) {
        String sql = "select id,`name` from tb_city_user where city = :city order by `name` desc limit 1000";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("city", city);
        List<SimpleCityUser> allUser =
                jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<SimpleCityUser>(SimpleCityUser.class));
        return allUser;
    }

    public List<CityUser> getDataByIds(List<Integer> ids) {
        String sql = "select city,`name`,age from tb_city_user where id in (:ids)";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ids", ids);
        List<CityUser> allUser =
                jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<CityUser>(CityUser.class));
        return allUser;
    }
}
