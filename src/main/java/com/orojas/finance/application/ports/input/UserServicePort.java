package com.orojas.finance.application.ports.input;

import com.orojas.finance.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserServicePort {

    User createUser(User user);
    List<User> getUsers();
    User getUserById(UUID id);
    User updateUser(UUID id, User user);
    void deleteUser(UUID id);
    String populateUsers();

}