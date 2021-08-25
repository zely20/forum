package ru.job4j.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.entity.User;
import ru.job4j.forum.service.UserService;

import javax.validation.ConstraintViolationException;

@Controller
public class RegControl {

    private final UserService userService;

    public RegControl(UserService userService) {
        this.userService = userService;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public String userAlreadyReg() {
        return "redirect:/reg?regError=true";
    }

    @GetMapping("/reg")
    public String reg(@RequestParam(value = "regError", required = false) String regError,
                      Model model) {
        String errorMessage = null;
        if (regError != null) {
            errorMessage = "Такой пользователь уже зарегистрирован";
        }
        model.addAttribute("error", errorMessage);
        return "reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }
}
