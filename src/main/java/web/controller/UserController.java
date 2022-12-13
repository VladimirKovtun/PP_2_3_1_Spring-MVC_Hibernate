package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;

@Controller()
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "users";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit_user";
    }
    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @ModelAttribute("user") User user) {
        userService.editUser(id,user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String removeUser(@ModelAttribute("user") User user) {
        userService.removeUser(user);
        return "redirect:/users";
    }

}
