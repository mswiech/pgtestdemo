package big.a03;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
//@FlywayTest(locationsForMigrate = "db/test-data")
//@FlywayTest
@AutoConfigureEmbeddedDatabase(beanName = "dataSource")
@ContextConfiguration(classes = A03AppConfiguration.class)
public class SpringPostgresTest {

//    @ClassRule
//    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
//
//    @Rule
//    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    private SomeServiceBean someServiceBean;

    @Test
    public void test() throws Exception {
        final Long a = someServiceBean.getValue("a");
        Assert.assertEquals(Long.valueOf(97L), a);

        final Long b = someServiceBean.getValue("b");
        Assert.assertEquals(Long.valueOf(98L), b);
    }
}
