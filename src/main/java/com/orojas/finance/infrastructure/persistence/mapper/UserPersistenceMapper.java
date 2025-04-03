package com.orojas.finance.infrastructure.persistence.mapper;

import com.orojas.finance.domain.model.User;
import com.orojas.finance.infrastructure.persistence.entity.UserEntity;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    UserEntity toUserEntity(User user);
    User toUser(UserEntity entity);
    List<User> toUserList(List<UserEntity> entityList);

}
