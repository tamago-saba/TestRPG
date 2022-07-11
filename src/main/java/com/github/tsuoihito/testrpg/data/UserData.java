package com.github.tsuoihito.testrpg.data;

import com.github.tsuoihito.testrpg.model.User;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserData {
    private final List<User> users = new ArrayList<>();

    public Optional<User> getUser(UUID uuid) {
        return users.stream().filter(user -> user.getUuid().equals(uuid)).findAny();
    }

    public Optional<User> getUser(String name) {
        return users.stream().filter(user -> user.getName().equalsIgnoreCase(name)).findAny();
    }

    public User addUser(String name, UUID uuid) {
        User user = new User(name, uuid);
        users.add(user);
        return user;
    }

}
