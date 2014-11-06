package cn.itcast.oa;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by lkk on 2014/11/6.
 */
public class AllTests {

    public static Test suite(){
        TestSuite suite=new TestSuite();
        suite.addTest(cn.itcast.oa.common.AllTests.suite());
        suite.addTest(cn.itcast.oa.dao.impl.AllTests.suite());
        return suite;
    }
}
