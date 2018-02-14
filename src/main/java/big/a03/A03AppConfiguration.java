package big.a03;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class A03AppConfiguration {

    @Resource
    private DataSource dataSource;

    @Bean
    public SomeServiceBean someServiceBean() {
        return new SomeServiceBean();
    }

    @Bean
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setBaselineOnMigrate(true);
        flyway.setLocations("classpath:db/a03-schema");
        flyway.setDataSource(dataSource);
        flyway.setSchemas("a03");
        return flyway;
    }
}
