package pl.sda.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EntityManagerProvider {

    private final static String URL = "";
    private final static String USER = "";
    private final static String PASSWORD = "";

    private final static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("", getEntityManagerProps());

    static Map<String, String> getEntityManagerProps() {
        Map<String, String> props = new HashMap<>();
        props.put("javax.persistence.jdbc.url", URL);
        props.put("javax.persistence.jdbc.user", USER);
        props.put("javax.persistence.jdbc.password", PASSWORD);
        return props;
    }

    public static EntityManager getEntityManager() {
        try {
            return entityManagerFactory.createEntityManager();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
