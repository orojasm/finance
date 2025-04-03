package com.orojas.finance.application.service;

import com.orojas.finance.application.ports.input.UserServicePort;
import com.orojas.finance.application.ports.output.UserPersistencePort;
import com.orojas.finance.domain.exception.UserNotFoundException;
import com.orojas.finance.domain.model.Permission;
import com.orojas.finance.domain.model.Role;
import com.orojas.finance.domain.model.RoleEnum;
import com.orojas.finance.domain.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService implements UserServicePort {
    private final UserPersistencePort persistencePort;

    @Override
    public User createUser(User user) {
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
        // Instantiate the Permissions
        Permission readPermission = Permission.builder().permissionName("READ").build();
        Permission whitePermission = Permission.builder().permissionName("WRITE").build();
        Permission updatePermission = Permission.builder().permissionName("UPDATE").build();
        Permission createPermission = Permission.builder().permissionName("CREATE").build();
        Permission deletePermission = Permission.builder().permissionName("DELETE").build();
        Permission refactorPermission = Permission.builder().permissionName("REFACTOR").build();

        // Instantiate the Roles
        Role adminRole = Role.builder()
                .roleName(RoleEnum.ADMIN)
                .permissionList(Set.of(createPermission, readPermission, whitePermission, updatePermission, deletePermission))
                .build();
        Role userRole = Role.builder()
                .roleName(RoleEnum.USER)
                .permissionList(Set.of(createPermission, readPermission))
                .build();
        Role invitedRole = Role.builder()
                .roleName(RoleEnum.INVITED)
                .permissionList(Set.of(readPermission))
                .build();
        Role developernRole = Role.builder()
                .roleName(RoleEnum.DEVELOPER)
                .permissionList(Set.of(createPermission, readPermission, whitePermission, updatePermission, deletePermission, refactorPermission))
                .build();

        // Instantiate the users
        User orojas = User.builder()
                .username("orojas")
                .password("1234")
                .roles(Set.of(developernRole))
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
        User july = User.builder()
                .username("july")
                .password("1234")
                .roles(Set.of(userRole))
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

        // persistencePort.saveAll(List.of(orojas, sofy, july, dany));
        persistencePort.save(orojas);
        persistencePort.save(sofy);
        persistencePort.save(july);
        persistencePort.save(dany);
        return "Populate Users.";
    }
}
