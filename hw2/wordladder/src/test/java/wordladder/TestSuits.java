package wordladder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by lightClouds917
 * Date 2018/2/2
 * Description:打包测试
 */
//@Ignore("not ready yet")
@RunWith(Suite.class)
@Suite.SuiteClasses({DictTest.class,LadderTest.class})
public class TestSuits {

    //不用写代码，只需要注解即可
}