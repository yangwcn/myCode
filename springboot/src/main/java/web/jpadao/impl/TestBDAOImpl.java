package web.jpadao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import web.bean.TestB;
import web.jpadao.TestBDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestBDAOImpl implements TestBDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<TestB> getAll() {
        return null;
    }

    public TestB getTestB(String cod) {
        TestB testB = new TestB();
        testB.setCod("yang");
        testB.setNam("nnn");

        StringBuffer query = new StringBuffer(100);
        query.append("INSERT INTO `test_b`  ");
        query.append("	( ");
        query.append("	`code`,  ");
        query.append("	`name`  ");
        query.append("	) ");
        query.append("	VALUES ");
        query.append("	( ");
        query.append("	:cod, ");
        query.append("	:nam ");
        query.append("	) ");

        Map<String,String> map = new HashMap<String, String>();
        map.put("code","code");
        map.put("name","name");
        int result = //namedParameterJdbcTemplate.update(query.toString(),map);
                namedParameterJdbcTemplate.update(query.toString(), new BeanPropertySqlParameterSource(testB));
        return null;
    }
}
