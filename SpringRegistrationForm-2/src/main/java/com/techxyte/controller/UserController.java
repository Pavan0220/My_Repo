package com.techxyte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.techxyte.entity.Employee;
import com.techxyte.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
@Autowired
private UserService userService;

@Autowired
private JavaMailSender mailSender;

@GetMapping("/register1")
public String showRegistrationForm() {
   
    return "register";
}

@PostMapping("/registration")
public String registerUser( @Valid @ModelAttribute Employee user, Model model) {
	String email = user.getEmail();
	int indexOf = email.indexOf("@");
	String substring = email.substring(0, indexOf);
	user.setUsername(substring);
    userService.saveUser(user);
    return "redirect:/login";
}
@GetMapping("/login")
public String showLoginForm(Model model) {
    model.addAttribute("user", new Employee());
    return "login";
}

@PostMapping("/login")
public String loginUser(@ModelAttribute Employee user, Model model, HttpSession session) {
    Employee existingUser = userService.findByEmail(user.getEmail());
    if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
        session.setAttribute("loggedInUser", existingUser);
        return "home";
    } else {
        sendPasswordByEmail(user.getEmail());
        model.addAttribute("error", "Invalid credentials. Password has been sent to your email.");
        return "login";
    }
}
private void sendPasswordByEmail(String email) {
    Employee user = userService.findByEmail(email);
    if (user != null) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your Password");
        message.setText("Your password is: " + user.getPassword()  +  " your username is:"+user.getUsername());
        mailSender.send(message);
    }
}


}
