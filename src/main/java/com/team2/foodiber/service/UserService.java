package com.team2.foodiber.service;

import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.model.User;
import com.team2.foodiber.repository.UserRepository;

public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User UserDtoToUser (UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(user.getUsername());
        return user;
    }

    private UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElse(null);
        if (user != null) {
            user.setEmail(userDto.getEmail());
            user.setUsername(userDto.getUsername());
            return toDto(userRepository.save(user));
        }
        return null;
    }
}
