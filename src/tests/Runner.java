package tests;

import data.Data;
import data.PropertyWorker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;

import java.util.HashMap;

/**
 * Created by user on 03.02.2017.
 */
public class Runner {

    Assertion assertion;
    PropertyWorker property = new PropertyWorker();

    TestExecutor testExecutor;

    @BeforeClass
    public void preCondition(){
        assertion = new Assertion();
        testExecutor = new TestExecutor();
    }

    @BeforeMethod
    public void before() {

    }

    @AfterMethod
    public void after() {

    }
}