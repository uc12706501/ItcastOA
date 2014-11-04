package cn.itcast.oa.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by lkk on 2014/11/4.
 */
public class AllTests{
    public static Test suite(){
        TestSuite suite=new TestSuite();
        suite.addTestSuite(TestActionTest.class);
        return suite;
    }
}
