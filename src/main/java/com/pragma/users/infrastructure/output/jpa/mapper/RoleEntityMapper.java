package com.pragma.users.infrastructure.output.jpa.mapper;

import com.pragma.users.domain.model.Role;
import com.pragma.users.infrastructure.output.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper {
    Role toRole(RoleEntity roleEntity);
    RoleEntity toEntity(Role role);
}
