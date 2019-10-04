package com.example.demo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class UserController {
  @Autowired
  private UserRepository userRepository;
  @GetMapping("/")
  public String landing(Model model){
    List<User> users = userRepository.findAll();
    model.addAttribute("users",users);
    return "landing";
  }
  @GetMapping("/adduser")
  public String getAddUser(Model model){
    model.addAttribute("user",new User());
    return "addUser";
  }
  @PostMapping(value = "/addUser")
  public String addUser(User user){
    userRepository.save(user);
    return "redirect:/";
  }
}
