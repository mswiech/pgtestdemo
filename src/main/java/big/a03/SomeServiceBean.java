package big.a03;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SomeServiceBean {

    @Resource
    private DataSource dataSource;

    public Long getValue(final String key) throws Exception {
        Long result = null;
        try (final Connection connection = dataSource.getConnection();
             final PreparedStatement ps = connection.prepareStatement("select value from a03.spring_test_table where key = ?")) {
            ps.setString(1, key);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getLong("value");
            }
            rs.close();
        }
        return result;
    }
}
