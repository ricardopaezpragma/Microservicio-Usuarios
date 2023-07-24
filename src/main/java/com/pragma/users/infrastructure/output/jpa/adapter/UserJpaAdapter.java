package com.pragma.users.infrastructure.output.jpa.adapter;

import com.pragma.users.domain.model.User;
import com.pragma.users.domain.spi.IUserPersistencePort;
import com.pragma.users.infrastructure.exception.UserException;
import com.pragma.users.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.pragma.users.infrastructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User saveUser(User user) {
        return userEntityMapper.toUser(userRepository.saveAndFlush(userEntityMapper.toEntity(user)));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findOneByEmail(email)
                .map(userEntityMapper::toUser)
                .orElseThrow(() -> new UserException("email: " + email));
    }

    @Override
    public User getById(int userId) {
        return userRepository.findById(userId)
                .map(userEntityMapper::toUser)
                .orElseThrow(() -> new UserException("id: " + userId));
    }

}
