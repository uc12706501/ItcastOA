package cn.itcast.oa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by lkk on 2014/11/6.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({cn.itcast.oa.common.AllTests.class,cn.itcast.oa.dao.impl.AllTests.class})
public class AllTests {

}
