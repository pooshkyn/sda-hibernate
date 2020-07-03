package pl.sda.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static pl.sda.infrastructure.JdbcUrlProvider.getJdbcUrl;

public interface CommonRepositoryAbility {
    String JDBC_URL = getJdbcUrl();
    LocalDateTime NOW = LocalDateTime.now(ZoneId.systemDefault());

    default void clearDB() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String query = "DELETE FROM appuser; DELETE FROM post; DELETE FROM follow;";

            try (Statement statement = connection.createStatement()) {
                statement.execute(query);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
