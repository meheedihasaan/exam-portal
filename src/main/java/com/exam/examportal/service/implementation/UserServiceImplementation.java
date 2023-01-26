package com.exam.examportal.service.implementation;

import com.exam.examportal.model.dto.UserDto;
import com.exam.examportal.model.dto.UserRoleDto;
import com.exam.examportal.model.entity.User;
import com.exam.examportal.model.entity.UserRole;
import com.exam.examportal.repository.RoleRepository;
import com.exam.examportal.repository.UserRepository;
import com.exam.examportal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    //To create a user
    @Override
    public UserDto createUser(UserDto userDto, Set<UserRoleDto> userRolesDto) throws Exception {
        User user = this.modelMapper.map(userDto, User.class);
        User existingUser = this.userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            System.out.println("User already exists.");
            throw new Exception("User already exists.");
        }
        else {
            for (UserRoleDto userRoleDto : userRolesDto) {
                UserRole userRole = this.modelMapper.map(userRoleDto, UserRole.class);
                roleRepository.save(userRole.getRole());
            }
            Set<UserRole> userRoles = userRolesDto
                                        .stream()
                                        .map((userRoleDto) -> this.modelMapper.map(userRoleDto, UserRole.class))
                                        .collect(Collectors.toSet());
            user.getUserRoles().addAll(userRoles);
            User savedUser = this.userRepository.save(user);
            System.out.println("User is created.");
            System.out.println(savedUser);
            return this.modelMapper.map(savedUser, UserDto.class);
        }
    }

}
