package Java.controller;

import Java.model.User;
import Java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("getUsers", userService.getAllUsers());
        return "/all";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/show";
    }

    @GetMapping("/new")
    public String saveUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
//
//    @GetMapping("/")
//    public String getAllUsers(Model model) {
//        List<User> allUsers = userService.getAllUsers();
//        model.addAttribute("user", allUsers);
//        return "userAll";
//    }
//
//    @GetMapping("/add-new-user")
//    public String addUser(Model model) {
//        model.addAttribute("user", new User());
//        return "userInfo";
//    }
//
//    @PostMapping("/")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/{id}/update")
//    public String updateInfo(@PathVariable(name = "id") Long id, Model model) {
//        model.addAttribute("user", userService.getUser(id));
//        return "userUpdate";
//    }
//
//    @PatchMapping("/")
//    public String updateUser(@ModelAttribute("user") User user) {
//        userService.updateUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String deleteInfo(@PathVariable(name = "id") Long id, Model model) {
//        model.addAttribute("user", userService.getUser(id));
//        return "userDelete";
//    }
//
//    @DeleteMapping("/")
//    public String deleteUser(@PathVariable("id") int id) {
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
}
