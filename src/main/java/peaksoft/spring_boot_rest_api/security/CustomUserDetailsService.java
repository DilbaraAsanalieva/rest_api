package peaksoft.spring_boot_rest_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.entity.CustomUserDetails;
import peaksoft.spring_boot_rest_api.entity.User;
import peaksoft.spring_boot_rest_api.service.UserService;

@Component
public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserService service;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.findByEmail(username);
        return CustomUserDetails.fromEntityToCustomUserDetails(user);
    }
}

