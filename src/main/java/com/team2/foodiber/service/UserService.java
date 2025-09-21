package com.team2.foodiber.service;

import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.exceptions.UsernameOrEmailIsAlreadyExisted;
import com.team2.foodiber.model.User;
import com.team2.foodiber.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


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


    public void saveUser(UserDto userDto) throws UsernameOrEmailIsAlreadyExisted {
        if (userRepository.existsByUsername(userDto.getUsername()) || userRepository.existsByEmail(userDto.getEmail())) {
            throw new UsernameOrEmailIsAlreadyExisted("Username or Email already exists!");
        }
        // If the user does not exist, proceed with saving the user
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword())); // Remember to encode passwords
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());

        userRepository.save(user);
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
    public String getLoggedInUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

}


