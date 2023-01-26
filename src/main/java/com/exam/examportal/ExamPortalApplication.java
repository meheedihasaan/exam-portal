package com.exam.examportal;

import com.exam.examportal.model.dto.RoleDto;
import com.exam.examportal.model.dto.UserDto;
import com.exam.examportal.model.dto.UserRoleDto;
import com.exam.examportal.model.entity.UserRole;
import com.exam.examportal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ExamPortalApplication.class, args);
    }

    //To map one object to another
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("mehedi");
        userDto.setPassword("1234");
        userDto.setFirstName("Mehedi");
        userDto.setLastName("Hasan");
        userDto.setEmail("mehedi@gmail.com");
        userDto.setProfileImage("user_profile.jpg");

        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setRoleName("ROLE_ADMIN");

        Set<UserRoleDto> userRolesDto = new HashSet<>();
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setRole(roleDto);
        userRoleDto.setUser(userDto);

        this.userService.createUser(userDto, userRolesDto);

    }
}
