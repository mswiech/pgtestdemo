package big.a01;

import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.SingleInstancePostgresRule;
import org.junit.Rule;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimplePostgresTest {

    @Rule
    public SingleInstancePostgresRule pg = EmbeddedPostgresRules.singleInstance();

    @Test
    public void test() throws Exception {
        final DataSource dataSource = pg.getEmbeddedPostgres().getPostgresDatabase();
        final Connection connection = dataSource.getConnection();
        final Statement statement = connection.createStatement();
        final ResultSet rs = statement.executeQuery("SELECT * FROM generate_series(1, 10) t(a)");

        System.out.println();
        System.out.println("-- TEST OUTPUT: --");
        while (rs.next()) {
            System.out.println(rs.getLong("a"));
        }
        System.out.println("-- :TEST OUTPUT --");
        System.out.println();

        rs.close();
        statement.close();
        connection.close();
    }

}
