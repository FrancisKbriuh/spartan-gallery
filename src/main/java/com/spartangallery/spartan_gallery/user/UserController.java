package com.spartangallery.spartan_gallery.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
     @Autowired
     private UserService userService;

     @GetMapping("/all")
    public List<User> getAllUsers() {
         return userService.getAllUsers();
     }

     @PostMapping("/new")
    public User createUser(@RequestBody User user) {
         return userService.saveUser(user);
     }
}
