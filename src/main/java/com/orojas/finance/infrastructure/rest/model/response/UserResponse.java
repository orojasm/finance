package com.orojas.finance.infrastructure.rest.model.response;

import com.orojas.finance.infrastructure.persistence.entity.RoleEntity;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UUID userId;
    private String username;
    private String password;
    private boolean isEnable;
    private boolean accountNoExpired;
    private boolean accountNoLocked;
    private boolean credentialNoExpired;
    private Set<RoleEntity> roles;
}
