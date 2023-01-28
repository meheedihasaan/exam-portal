package com.exam.examportal.service;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;

import java.util.Set;

public interface UserService {

    //To create a new user
    User createUser(User user, Set<UserRole> userRoles) throws Exception;

}
