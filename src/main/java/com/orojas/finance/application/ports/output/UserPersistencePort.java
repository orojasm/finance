package com.orojas.finance.application.ports.output;

import com.orojas.finance.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserPersistencePort {

    User save(User user);
    List<User> findAll();
    Optional<User> findById(UUID id);
    void delete(UUID id);

}
