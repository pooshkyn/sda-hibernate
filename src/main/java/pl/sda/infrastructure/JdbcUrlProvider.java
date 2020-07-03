package pl.sda.infrastructure;

import java.util.Map;

public class JdbcUrlProvider {

    public static String getJdbcUrl() {
        Map<String, String> props = EntityManagerProvider.getEntityManagerProps();
        return props.get("javax.persistence.jdbc.url") +
                "&user=" +
                props.get("javax.persistence.jdbc.user") +
                "&password=" +
                props.get("javax.persistence.jdbc.password") +
                "&allowMultiQueries=true";
    }
}
