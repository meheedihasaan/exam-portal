package com.exam.examportal.service;

import com.exam.examportal.model.dto.UserDto;
import com.exam.examportal.model.dto.UserRoleDto;

import java.util.Set;

public interface UserService {

    //To create a user
    UserDto createUser(UserDto userDto, Set<UserRoleDto> userRolesDto) throws Exception;

}
