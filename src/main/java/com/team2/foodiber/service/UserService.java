package com.team2.foodiber.service;

import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.model.User;
import com.team2.foodiber.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    public final UserRepository userRepository;

    private User UserDtoToUser (UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        return user;
    }

    private UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        return userDto;
    }

    public UserDto saveUser(UserDto user) {
        User newUser = new User();
        return toDto(userRepository.save(newUser));
    }

//    public UserDto updateUser(Long id, UserDto userDto) {
//        User user = userRepository.findById(id)
//                .orElse(null);
//        if (user != null) {
//            user.setEmail(userDto.getEmail());
//            user.setUsername(userDto.getUsername());
//            user.setName(userDto.getName());
//            return toDto(userRepository.save(user));
//        }
//        return null;
//    }
}
