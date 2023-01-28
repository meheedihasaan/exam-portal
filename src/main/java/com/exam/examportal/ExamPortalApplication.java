package com.exam.examportal;

import com.exam.examportal.model.Role;
import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;
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
        User user = new User();
        user.setUsername("fariya");
        user.setPassword("1234");
        user.setFirstName("Fariya");
        user.setLastName("Richie");
        user.setEmail("fariya@gmail.com");
        user.setPhone("01306199926");
        user.setProfileImage("user_profile.jpg");

        Role role = new Role();
        role.setId(1);
        role.setRoleName("ROLE_ADMIN");

        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        userRoles.add(userRole);

        this.userService.createUser(user, userRoles);

    }
}
