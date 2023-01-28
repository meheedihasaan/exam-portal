package com.exam.examportal.service.implementation;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;
import com.exam.examportal.repository.RoleRepository;
import com.exam.examportal.repository.UserRepository;
import com.exam.examportal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    //To create a new user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User existingUser = this.userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            System.out.println("User already exists.");
            throw new Exception("User already exists.");
        }
        else {
            for (UserRole userRole : userRoles) {
                this.roleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            User savedUser = this.userRepository.save(user);
            return savedUser;
        }

    }
}
