package com.orojas.finance.infrastructure.persistence;

import com.orojas.finance.application.ports.output.UserPersistencePort;
import com.orojas.finance.domain.model.User;
import com.orojas.finance.infrastructure.persistence.entity.UserEntity;
import com.orojas.finance.infrastructure.persistence.mapper.UserPersistenceMapper;
import com.orojas.finance.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository repository;
    private final UserPersistenceMapper mapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = repository.save(mapper.toUserEntity(user));
        return mapper.toUser(userEntity);
    }

    @Override
    public List<User> findAll() {
        return mapper.toUserList(repository.findAll());
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toUser);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
