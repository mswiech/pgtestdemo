package big.a03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@Import(FakeDatasourceConfiguration.class)
@EnableTransactionManagement
public class A03AppConfiguration {

    @Resource
    private DataSource dataSource;

    @Bean
    public SomeServiceBean someServiceBean() {
        return new SomeServiceBean();
    }

}
