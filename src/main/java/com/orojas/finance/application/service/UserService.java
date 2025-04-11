package com.orojas.finance.application.service;

import com.orojas.finance.application.ports.input.UserServicePort;
import com.orojas.finance.application.ports.output.UserPersistencePort;
import com.orojas.finance.domain.exception.UserNotFoundException;
import com.orojas.finance.domain.model.Role;
import com.orojas.finance.domain.model.RoleList;
import com.orojas.finance.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserServicePort {
    private final UserPersistencePort persistencePort;

    @Override
    public User createUser(User user) {
        // TODO Verify that when creating a user, no roles are sent in the request.
        Role userRole = Role.builder()
                .id(1L)
                .roleName(RoleList.USER)
                .build();
        user.setRoles(Set.of(userRole));
        log.debug(user.toString());
        log.debug(userRole.toString());

        return persistencePort.save(user);
    }

    @Override
    public List<User> getUsers() {
        return persistencePort.findAll();
    }

    @Override
    public User getUserById(UUID id) {
        return persistencePort.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User updateUser(UUID id, User user) {
        return persistencePort.findById(id)
                .map(saveUser -> {
                    saveUser.setId(user.getId());
                    saveUser.setUsername(user.getUsername());
                    saveUser.setPassword(user.getPassword());
                    saveUser.setEnabled(user.isEnabled());
                    saveUser.setAccountNoExpired(user.isAccountNoExpired());
                    saveUser.setAccountNoLocked(user.isAccountNoLocked());
                    saveUser.setCredentialNoExpired(user.isCredentialNoExpired());
                    saveUser.setRoles(user.getRoles());
                    return persistencePort.save(user);
                })
                .orElseThrow(UserNotFoundException::new);
    }

    // FIXME: - Priority: HIGH *  Delete doesn't work. Check delete cascade for permissions.
    @Override
    public void deleteUser(UUID id) {
        persistencePort.delete(id);
    }

    @Override
    public String populateUsers() {

        // Instantiate the Roles
        Role userRole = Role.builder()
                .roleName(RoleList.USER)
                .build();
        Role adminRole = Role.builder()
                .roleName(RoleList.ADMIN)
                .build();
        Role invitedRole = Role.builder()
                .roleName(RoleList.INVITED)
                .build();
        Role developernRole = Role.builder()
                .roleName(RoleList.DEVELOPER)
                .build();

        // Instantiate the users
        User july = User.builder()
                .username("july")
                .password("1234")
                .roles(Set.of(userRole))
                .isEnabled(true)
                .accountNoExpired(true)
                .accountNoLocked(true)
                .credentialNoExpired(true)
                .build();
        User sofy = User.builder()
                .username("sofy")
                .password("1234")
                .roles(Set.of(adminRole))
                .isEnabled(true)
                .accountNoExpired(true)
                .accountNoLocked(true)
                .credentialNoExpired(true)
                .build();
        User dany = User.builder()
                .username("dany")
                .password("1234")
                .roles(Set.of(invitedRole))
                .isEnabled(true)
                .accountNoExpired(true)
                .accountNoLocked(true)
                .credentialNoExpired(true)
                .build();
        User orojas = User.builder()
                .username("orojas")
                .password("1234")
                .roles(Set.of(developernRole))
                .isEnabled(true)
                .accountNoExpired(true)
                .accountNoLocked(true)
                .credentialNoExpired(true)
                .build();

        // persistencePort.saveAll(List.of(july, sofy, dany, orojas));
        persistencePort.save(july);
        persistencePort.save(sofy);
        persistencePort.save(dany);
        persistencePort.save(orojas);
        return "Populate Users.";
    }
}
