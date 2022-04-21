package com.baraka.bank.service;

import com.baraka.bank.model.entities.User;
import com.baraka.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
    implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(final User user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(final Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findById(final long userId) {

        return userRepository.findById(userId).get();
    }
}
