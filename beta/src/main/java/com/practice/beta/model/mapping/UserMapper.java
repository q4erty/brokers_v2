package com.practice.beta.model.mapping;

import com.practice.beta.model.dto.UserDTO;
import com.practice.beta.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserEntity toUser(UserDTO userDTO);

    UserDTO toUserDTO(UserEntity userEntity);
}
