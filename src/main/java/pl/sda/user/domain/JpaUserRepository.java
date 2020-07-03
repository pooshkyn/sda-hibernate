package pl.sda.user.domain;

import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    @Override
    public boolean isConnectionValid() {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void changePassword(String username, String password) {

    }

    @Override
    public void deleteByUsername(String username) {

    }
}
