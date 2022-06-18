package peaksoft.spring_boot_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.spring_boot_rest_api.dto.AuthResponse;
import peaksoft.spring_boot_rest_api.dto.RegisterRequest;
import peaksoft.spring_boot_rest_api.entity.User;
import peaksoft.spring_boot_rest_api.security.JwtProvider;
import peaksoft.spring_boot_rest_api.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider provider;

    public String registerUser(@RequestBody RegisterRequest request){
        User user = new User();
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        userService.saveUser(user);
        return "OK";
    }

    public AuthResponse auth(@RequestBody RegisterRequest request){
        User user = userService.findByLoginAndPassword(request.getEmail(),request.getPassword());

    }
}
