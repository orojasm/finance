package com.orojas.finance.infrastructure.rest.model.request;

import com.orojas.finance.infrastructure.persistence.entity.RoleEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "Field username cannot be blank, empty or null.")
    private String username;
    private String password;
    private boolean isEnable;
    private boolean accountNoExpired;
    private boolean accountNoLocked;
    private boolean credentialNoExpired;
    private Set<RoleEntity> roles;
}
