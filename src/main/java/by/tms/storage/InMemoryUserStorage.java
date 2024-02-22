package by.tms.storage;

import by.tms.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserStorage {
    private final static List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public User findByUsername(String username) {
        Optional<User> first = users
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
        return first.orElseThrow();
    }
}
