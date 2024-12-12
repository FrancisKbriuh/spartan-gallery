package com.spartangallery.spartan_gallery.user;

import com.spartangallery.spartan_gallery.artist.Transaction;
import com.spartangallery.spartan_gallery.artist.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("user", user);
            return "redirect:/search"; // Redirect to search page after login
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; // Redirect to login page if authentication fails
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal User user, Model model) {
        List<Transaction> transactions = transactionRepository.findByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("transactions", transactions);
        return "profile";
    }   @GetMapping("/all")
    public List<User> getAllUsers() {
         return userService.getAllUsers();
     }

     @PostMapping("/new")
    public User createUser(@RequestBody User user) {
         return userService.saveUser(user);
     }
}
