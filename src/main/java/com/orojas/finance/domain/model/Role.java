package com.orojas.finance.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    private Long id;
    private RoleList roleName;
}