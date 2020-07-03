package pl.sda.support;

import pl.sda.follow.Follow;
import pl.sda.infrastructure.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Optional;

public interface FollowRepositoryAbility extends CommonRepositoryAbility {

    default Optional<Follow> findFollow(int id) {
        try {
            EntityManager em = EntityManagerProvider.getEntityManager();
            Follow follow = em.find(Follow.class, id);
            em.detach(follow);
            return Optional.of(follow);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    default void addFollows() {
        Timestamp timestamp = Timestamp.valueOf(NOW.minusHours(6));
        Timestamp timestamp2 = Timestamp.valueOf(NOW.minusHours(2));
        Timestamp timestamp3 = Timestamp.valueOf(NOW.minusDays(2));

        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("INSERT INTO follow (id, follower, followee, creationdate) VALUES " +
                        "('1', 'jan', 'mietek', '" + timestamp.toString() + "'), " +
                        "('2', 'mietek', 'jan', '" + timestamp2.toString() + "'), " +
                        "('3', 'jan', 'testuser', '" + timestamp3.toString() + "')");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
