package by.tms.service;

import by.tms.model.User;
import by.tms.storage.InMemoryUserStorage;

public class UserService {
    private final InMemoryUserStorage storage = new InMemoryUserStorage();

    public void add(User user) {
        storage.save(user);
    }

    public User findByUsername(String username)  {
        return storage.findByUsername(username);
    }
}
