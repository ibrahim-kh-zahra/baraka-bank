package com.baraka.bank.service;

import com.baraka.bank.model.entities.User;

public interface UserService {
    public User createUser(User user);

    public void deleteUser(Long userId);

    User findById(long userId);
}
