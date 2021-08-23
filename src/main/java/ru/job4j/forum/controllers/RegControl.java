package ru.job4j.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.entity.User;

import javax.validation.ConstraintViolationException;

@Controller
public class RegControl {

    public RegControl() {
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
        return "redirect:/login";
    }
}
