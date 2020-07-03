package pl.sda.post.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sda.support.PostRepositoryAbility;
import pl.sda.support.UserRepositoryAbility;
import pl.sda.user.domain.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PostRepositoryTest implements PostRepositoryAbility, UserRepositoryAbility {

    private final static String USERNAME = "jan";
    private final static int ID = 1;
    private final static User USER = new User(USERNAME, "alternatywy4", new HashSet<>(), new HashSet<>());
    private final static User USER2 = new User("testuser", "haslo", new HashSet<>(), new HashSet<>());
    private final static User USER3 = new User("mietek", "qwerty123", new HashSet<>(), new HashSet<>());
    private final static Post POST = new Post(1, "test", USER, NOW);
    private final static Post POST2 = new Post(2, "lorem ipsum", USER3, NOW.minusDays(1));
    private final static Post POST3 = new Post(3, "ipsum lorem", USER, NOW.minusHours(4));

    PostRepository postRepository = new JpaPostRepository();

    @BeforeEach
    void init() {
       clearDB();
    }

    @Test
    void testFindUserPosts() {
        //given
        addUsers();
        addPosts();
        //when
        List<Post> result = postRepository.findUserPosts(USERNAME);
        //then
        assertTrue(result.contains(POST));
        assertTrue(result.contains(POST3));
    }

    @Test
    void testAddPost() {
        //when
        addUsers();
        int postId = postRepository.addPost(new Post(null, "test", USER, NOW));
        //then
        Optional<Post> post = findPost(postId);
        assertTrue(post.isPresent());
        assertEquals(new Post(postId, "test", USER, NOW), post.get());
    }

    @Test
    void testFindDailyPosts() {
        //given
        addUsers();
        addPosts();
        //when
        List<Post> result = postRepository.findDailyPosts();
        //then
        assertTrue(result.contains(POST));
        assertTrue(result.contains(POST2));
    }

    @Test
    void testFindById() {
        //given
        addUsers();
        addPosts();
        //when
        Optional<Post> result = postRepository.findById(ID);
        //then
        assertTrue(result.isPresent());
        assertEquals(POST, result.get());
    }

    @Test
    void testFindById_postDoesNotExists() {
        //when
        Optional<Post> result = postRepository.findById(ID);
        //then
        assertFalse(result.isPresent());
    }

    @Test
    void testEditPost() {
        //given
        String newContent = "some new content";
        Post expectedPost = new Post(1, newContent, USER, NOW);
        addUsers();
        addPosts();
        //when
        postRepository.editPost(ID, "some new content");
        //then
        Optional<Post> post = findPost(ID);
        assertTrue(post.isPresent());
        assertEquals(expectedPost, post.get());
    }

    @Test
    void testDeletePost() {
        //given
        addUsers();
        addPosts();
        //when
        postRepository.deletePost(1);
        //then
        assertFalse(findPost(ID).isPresent());
    }
}

