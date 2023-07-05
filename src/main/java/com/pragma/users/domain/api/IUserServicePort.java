package com.pragma.users.domain.api;

import com.pragma.users.domain.model.User;

public interface IUserServicePort {
    User saveUser(User user);
    User getUserByEmail(String email);
    User getById(int userId);
}
