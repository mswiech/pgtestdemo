package big.a02;

import com.opentable.db.postgres.embedded.FlywayPreparer;
import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.PreparedDbRule;
import org.junit.Rule;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedPostgresTest {
    @Rule
    public PreparedDbRule pg = EmbeddedPostgresRules.preparedDatabase(
            FlywayPreparer.forClasspathLocation("db/prepared-postgres-test"));
    @Test
    public void test() throws Exception {
        final DataSource dataSource = pg.getTestDatabase();
        final Connection connection = dataSource.getConnection();
        final Statement statement = connection.createStatement();
        final ResultSet rs = statement.executeQuery("SELECT * FROM test_table");
        while (rs.next()) {
            final String key = rs.getString("key");
            final Long value = rs.getLong("value");
            System.out.println(key + "=" + value);
        }
        rs.close();
        statement.close();
        connection.close();
    }
}
