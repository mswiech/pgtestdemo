package big.a03;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
public class FakeDatasourceConfiguration {

    /**
     * Fake DatasourceBean as placeholder for replacement by AutoConfigureEmbeddedDatabase(beanName = "dataSource") in SpringPostgresTest.
     * @return DataSource
     */
    @Bean
    public ProxyFactoryBean dataSource() {
        final ProxyFactoryBean result = new ProxyFactoryBean();
        result.setTargetSource(new TargetSource() {
            @Override
            public Class<?> getTargetClass() {
                return DataSource.class;
            }

            @Override
            public boolean isStatic() {
                return false;
            }

            @Override
            public Object getTarget() throws Exception {
                return new FakeDataSource();
            }

            @Override
            public void releaseTarget(final Object o) throws Exception {
            }
        });
        return result;
    }

    public static class FakeDataSource implements DataSource {
        @Override
        public Connection getConnection() throws SQLException {
            return null;
        }
        @Override
        public Connection getConnection(final String username, final String password) throws SQLException {
            return null;
        }
        @Override
        public <T> T unwrap(final Class<T> iface) throws SQLException {
            return null;
        }
        @Override
        public boolean isWrapperFor(final Class<?> iface) throws SQLException {
            return false;
        }
        @Override
        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }
        @Override
        public void setLogWriter(final PrintWriter out) throws SQLException {

        }
        @Override
        public void setLoginTimeout(final int seconds) throws SQLException {

        }
        @Override
        public int getLoginTimeout() throws SQLException {
            return 0;
        }
        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    }
}
