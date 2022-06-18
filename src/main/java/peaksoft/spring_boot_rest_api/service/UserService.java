package peaksoft.spring_boot_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.entity.Role;
import peaksoft.spring_boot_rest_api.entity.User;
import peaksoft.spring_boot_rest_api.repository.RoleRepository;
import peaksoft.spring_boot_rest_api.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        Role userRole = roleRepository.findByRoleName("ROLE_ADMIN");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findByLoginAndPassword(String email, String password){
        User user = findByEmail(email);
        if(user != null){
            if(passwordEncoder.matches(password, user.getPassword()));
            return user;
        }
        return null;
    }

}
