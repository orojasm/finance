package com.orojas.finance.infrastructure.rest.model.request;

import com.orojas.finance.infrastructure.rest.model.RoleDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {
    private UUID id;
    @NotBlank(message = "Field username cannot be blank, empty or null.")
    private String username;
    private String password;
    private boolean isEnabled;
    private boolean accountNoExpired;
    private boolean accountNoLocked;
    private boolean credentialNoExpired;
    private Set<RoleDto> roles;
}
