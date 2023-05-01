package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
    public class LoginController {

        @PostMapping("/login")
        public String doLogin(@ModelAttribute("user") User user, HttpServletRequest request) {
            System.out.println("Me cago en dios y en la madre que me parió");
            // do the authentication logic here
        /*
            // Get the user from the database using the username
            User userFromDB = userRepository.findByUsername(user.getUsername());

            if (userFromDB != null && userFromDB.getPassword().equals(user.getPassword())) {
                // Authentication successful, set user session
                HttpSession session = request.getSession();
                session.setAttribute("user", userFromDB);
                return "redirect:/index";
            } else {
                // Authentication failed, show error message
                request.setAttribute("error", "Invalid username or password");
                return "login";
        }
         */

            // set user session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            return "redirect:/index";
        }
}
