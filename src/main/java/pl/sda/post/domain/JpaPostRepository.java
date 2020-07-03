package pl.sda.post.domain;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class JpaPostRepository implements PostRepository {

    @Override
    public List<Post> findUserPosts(String username) {
        return null;
    }

    @Override
    public int addPost(Post post) {
        return 0;
    }

    @Override
    public List<Post> findDailyPosts() {
        return null;
    }

    @Override
    public Optional<Post> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void editPost(int id, String newText) {

    }

    @Override
    public void deletePost(int id) {

    }
}
