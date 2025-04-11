package com.orojas.finance.infrastructure.rest.mapper;

import com.orojas.finance.domain.model.User;
import com.orojas.finance.infrastructure.rest.model.request.UserRequest;
import com.orojas.finance.infrastructure.rest.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRestMapper {

    @Mapping(target = "isEnabled", source = "enabled")
    User toUser(UserRequest request);
    @Mapping(target = "isEnabled", source = "enabled")
    UserResponse toUserResponse(User user);
    List<UserResponse> toUserResponseList(List<User> requestList);

}
