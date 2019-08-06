package web.dao;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import web.bean.TestA;

import java.util.List;

@Repository
public interface TestaMapper {
    List<TestA> getAll(RowBounds rowBounds);
    TestA getTesta(String code);
}
