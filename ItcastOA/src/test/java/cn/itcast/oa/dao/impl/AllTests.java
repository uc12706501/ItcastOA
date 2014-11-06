package cn.itcast.oa.dao.impl;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by lkk on 2014/11/6.
 */
public class AllTests {
    public static Test suite(){
        TestSuite suite=new TestSuite();
        suite.addTestSuite(UserDaoImplTest.class);
        return  suite;
    }
}
