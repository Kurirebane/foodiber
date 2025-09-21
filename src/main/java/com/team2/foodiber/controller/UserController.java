package com.team2.foodiber.controller;

import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.exceptions.UsernameOrEmailIsAlreadyExisted;
import com.team2.foodiber.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "create-user";
    }

    @PostMapping("/create")
    public String createUser(@RequestParam("username") String username,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("confirmPassword") String confirmPassword,
                             RedirectAttributes redirectAttributes) {
        if (!password.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("error", "Passwords do not match.");
            return "redirect:/";
        }

        try {
            UserDto userDto = new UserDto();
            userDto.setUsername(username);
            userDto.setEmail(email);
            userDto.setPassword(password);
            userService.saveUser(userDto);
            redirectAttributes.addFlashAttribute("success", "User created successfully!");
            return "redirect:/";
        } catch (UsernameOrEmailIsAlreadyExisted e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred: " + e.getMessage());
            return "redirect:/";
        }
    }

    @GetMapping("/success")
    public String showSuccessMessage(Model model) {
        return "success";
    }
}