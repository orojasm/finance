package com.orojas.finance.infrastructure.rest.model;

import com.orojas.finance.domain.model.RoleList;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private RoleList roleName;
}