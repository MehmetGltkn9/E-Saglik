package DAO;

import Entity.TestResult;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class TestResultDAO extends AbstractDAO<TestResult> implements Serializable {

    public TestResultDAO() {
        super(TestResult.class);
    }

}