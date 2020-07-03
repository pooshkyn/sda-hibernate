package pl.sda.user.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sda.support.UserRepositoryAbility;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest implements UserRepositoryAbility {

    private final static String USERNAME = "jan";
    private final static String PASSWORD = "alternatywy4";
    private final static User USER = new User(USERNAME, PASSWORD, new HashSet<>(), new HashSet<>());
    private final static User USER2 = new User("testuser", "haslo", new HashSet<>(), new HashSet<>());
    private final static User USER3 = new User("mietek", "qwerty123", new HashSet<>(), new HashSet<>());

    UserRepository userRepository = new JpaUserRepository();

    @BeforeEach
    void init() {
        clearDB();
    }

    @Test
    void testConnectionToDatabase() {
        //when
        boolean isConnectionValid = userRepository.isConnectionValid();
        //then
        assertTrue(isConnectionValid);
    }

    @Test
    void testAddExampleUser() {
        //when
        userRepository.addExampleUser();
        //then
        Optional<User> actualUser = findUser("testuser");
        assertTrue(actualUser.isPresent());
        assertEquals(actualUser.get(), USER2);
    }

    @Test
    void testFindAllUsers() {
        //given
        addUsers();
        //when
        List<User> users = userRepository.findAll();
        //then
        assertEquals(3, users.size());
        assertTrue(users.contains(USER));
        assertTrue(users.contains(USER2));
        assertTrue(users.contains(USER3));
    }

    @Test
    void testAddUser() {
        //when
        userRepository.addUser(USER);
        //then
        Optional<User> actualUser = findUser(USERNAME);
        assertTrue(actualUser.isPresent());
        assertEquals(actualUser.get(), USER);
    }

    @Test
    void testFindByUsername() {
        //given
        addUser();
        //when
        Optional<User> actualUser = userRepository.findByUsername(USERNAME);
        //then
        assertTrue(actualUser.isPresent());
        assertEquals(actualUser.get(), USER);
    }

    @Test
    void testFindByUsername_userDoesNotExists() {
        //when
        Optional<User> actualUser = userRepository.findByUsername(USERNAME);
        //then
        assertFalse(actualUser.isPresent());
    }

    @Test
    void testChangePassword() {
        //given
        String newPassword = "hibernate1";
        addUser();
        //when
        userRepository.changePassword(USERNAME, newPassword);
        //then
        Optional<User> actualUser = findUser(USERNAME);
        assertTrue(actualUser.isPresent());
        assertEquals(newPassword, actualUser.get().getPassword());
    }

    @Test
    void testDeleteByUsername() {
        //given
        addUser();
        //when
        userRepository.deleteByUsername(USERNAME);
        //then
        Optional<User> actualUser = findUser(USERNAME);
        assertFalse(actualUser.isPresent());
    }
}
