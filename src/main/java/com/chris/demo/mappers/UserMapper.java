package com.chris.demo.mappers;

import com.chris.demo.dtos.user.UserGetDto;
import com.chris.demo.dtos.user.UserPostDto;
import com.chris.demo.dtos.user.UserPutDto;
import com.chris.demo.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
//    @Mapping(source="", target="") is used where source and target are not the same.
    User toEntity(UserPostDto userPostDto);
    UserGetDto fromEntity(User user);
    void copy(UserPutDto userPutDto, @MappingTarget User user);
    List<UserGetDto> fromEntities(List<User> users);
}
