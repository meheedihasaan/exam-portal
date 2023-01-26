package com.exam.examportal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String profileImage;

    private boolean status = true;

    private Set<UserRoleDto> userRoles = new HashSet<>();

}
