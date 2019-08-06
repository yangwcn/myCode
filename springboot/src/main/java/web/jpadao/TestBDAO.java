package web.jpadao;

import web.bean.TestB;

import java.util.List;

public interface TestBDAO {
    List<TestB> getAll();

    TestB getTestB(String cod);
}
