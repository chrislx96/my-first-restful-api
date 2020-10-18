package com.chris.demo.services;

import com.chris.demo.dtos.user.UserGetDto;
import com.chris.demo.dtos.user.UserPostDto;
import com.chris.demo.dtos.user.UserPutDto;
import com.chris.demo.entities.User;
import com.chris.demo.mappers.UserMapper;
import com.chris.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserGetDto create(UserPostDto userPostDto) {
        User userEntity = userMapper.toEntity(userPostDto);
        return userMapper.fromEntity(userRepository.save(userEntity));
    }

    public UserGetDto update(UUID userId, UserPutDto userPutDto) {
        User user = new User();
        userMapper.copy(userPutDto, user);
        user.setId(userId);
        return userMapper.fromEntity(userRepository.save(user));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public UserGetDto findById(UUID id) {
        return userMapper.fromEntity(userRepository.getOne(id));
    }

    public List<UserGetDto> findByFirstName(String firstName){
        return userMapper.fromEntities(userRepository.findUserByFirstName(firstName));
    }

    public List<UserGetDto> findByLastName(String lastName){
        return userMapper.fromEntities(userRepository.findUserByLastName(lastName));
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
