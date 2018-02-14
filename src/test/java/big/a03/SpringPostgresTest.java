package big.a03;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@FlywayTest(locationsForMigrate = "db/spring-postgres-test")
@AutoConfigureEmbeddedDatabase(beanName = "dataSource")
@ContextConfiguration(classes = A03AppConfiguration.class)
public class SpringPostgresTest {

    @Autowired
    private SomeServiceBean someServiceBean;

    @Test
    public void test() throws Exception {
        final Long a = someServiceBean.getValue("a");
        Assert.assertEquals(Long.valueOf(1L), a);

        final Long b = someServiceBean.getValue("b");
        Assert.assertEquals(Long.valueOf(2L), b);
    }
}
