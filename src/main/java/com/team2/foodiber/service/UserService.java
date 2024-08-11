package com.team2.foodiber.service;

import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.model.User;
import com.team2.foodiber.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    private User UserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        return user;
    }


    private UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        return userDto;
    }


    public UserDto saveUser(UserDto userDto) {
        User user = UserDtoToUser(userDto);
        User savedUser = userRepository.save(user);
        return toDto(savedUser);
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElse(null);
        if (user != null) {
            user.setEmail(userDto.getEmail());
            user.setUsername(userDto.getUsername());
            user.setName(userDto.getName());
            return toDto(userRepository.save(user));
        }
        return null;
    }

}


