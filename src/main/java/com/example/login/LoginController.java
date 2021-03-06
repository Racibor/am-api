package com.example.login;

import com.example.security.User;
import com.example.security.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
@RequestMapping("")
public class LoginController {

    UserRepository userRepository;

    private HttpSession httpSession;

    public LoginController(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    @PostMapping("/login")
    public Map<String, String> login(HttpServletRequest httpRequest) {
        Map<String, String> response = new HashMap<>();
        String auth = httpRequest.getHeader("Authentication");
        if(auth != null) {
            String[] parts = auth.split(":");
            if(parts.length == 2) {
                User user = userRepository.getUser(parts[0]);
                if(user != null) {
                    if(user.pass.equals(parts[1])) {
                        httpSession.setAttribute("user", user);
                        response.put("success", "true");
                    }
                } else {
                    response.put("errorMsg", "no such user");
                }
            } else {
                response.put("errorMsg", "use login:pass format");
            }
        } else {
            response.put("errorMsg", "lacking authentication header");
        }
        return response;
    }

    @GetMapping("/logout")
    public Map<String, String> logout(HttpServletRequest httpRequest) {
        Map<String, String> response = new HashMap<>();
        httpSession.setAttribute("user", null);
        response.put("sucess", "true");
        return response;
    }
}
