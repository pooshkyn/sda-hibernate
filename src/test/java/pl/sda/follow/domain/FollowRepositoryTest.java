package pl.sda.follow.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sda.follow.Follow;
import pl.sda.follow.FollowRepository;
import pl.sda.follow.JpaFollowRepository;
import pl.sda.support.FollowRepositoryAbility;
import pl.sda.support.UserRepositoryAbility;
import pl.sda.user.domain.User;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FollowRepositoryTest implements FollowRepositoryAbility, UserRepositoryAbility {

    private final static User USER = new User("jan", "alternatywy4", new HashSet<>(), new HashSet<>());
    private final static User USER2 = new User("testuser", "haslo", new HashSet<>(), new HashSet<>());
    private final static User USER3 = new User("mietek", "qwerty123", new HashSet<>(), new HashSet<>());

    FollowRepository followRepository = new JpaFollowRepository();

    @BeforeEach
    void init() { clearDB(); }

    @Test
    void testFollow() {
        //given
        addUsers();
        //when
        int followId = followRepository.follow(USER.getUsername(), USER3.getUsername());
        //then
        Optional<Follow> follow = findFollow(followId);
        User userPerformedFollow = findUser("jan").get();
        User userHasBeenFollowed = findUser("mietek").get();

        assertTrue(follow.isPresent());
        assertEquals(userPerformedFollow, follow.get().getFollower());
        assertEquals(userHasBeenFollowed, follow.get().getFollowee());

        assertTrue(userPerformedFollow.getFollowees().contains(follow.get()));
        assertTrue(userHasBeenFollowed.getFollowers().contains(follow.get()));
    }

    @Test
    void testUnfollow() {
        //given
        addUsers();
        addFollows();
        //when
        followRepository.unfollow("jan", "mietek");
        //then
        Optional<Follow> follow = findFollow(1);
        assertFalse(follow.isPresent());
    }
}
