package com.peaksoft.crud.controller;
import com.peaksoft.crud.model.User;
import com.peaksoft.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute User user) {
        return "add";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }
}
