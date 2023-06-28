package com.pragma.users.infrastructure.output.jpa.mapper;

import com.pragma.users.domain.model.User;
import com.pragma.users.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    User toUser(UserEntity userEntity);
    UserEntity toEntity(User user);
}
