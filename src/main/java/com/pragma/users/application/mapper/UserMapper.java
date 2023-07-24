package com.pragma.users.application.mapper;

import com.pragma.users.application.dto.UserDto;
import com.pragma.users.application.handler.IRoleHandler;
import com.pragma.users.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {
    @Autowired
    private IRoleHandler roleHandler;
    @Mapping(target = "roleId", expression = "java(getRoleIdByRoleName(userDto.getRole()))")
    public abstract User userDtoToUser(UserDto userDto);

    @Mapping(target = "role", expression = "java(getRoleNameByRoleId(user.getRoleId()))")
    public abstract UserDto userToUserDto(User user);

    protected String getRoleNameByRoleId(int userId) {
        return roleHandler.getRoleById(userId).getName();
    }
    protected int getRoleIdByRoleName(String role) {
        return roleHandler.getRoleByName(role).getId();
    }
}
