package pl.sda.support;


import pl.sda.infrastructure.EntityManagerProvider;
import pl.sda.user.domain.User;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Optional;

public interface UserRepositoryAbility extends CommonRepositoryAbility {

    default void addUser() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("INSERT INTO appuser (username, password) VALUES ('jan', 'alternatywy4')");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    default void addUsers() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("INSERT INTO appuser (username, password) VALUES " +
                        "('jan', 'alternatywy4'), ('testuser', 'haslo'), ('mietek', 'qwerty123')");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    default Optional<User> findUser(String username) {
        try {
            EntityManager em = EntityManagerProvider.getEntityManager();
            em.getTransaction().begin();
            User user = em.find(User.class, username);
            em.detach(user);
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


}
