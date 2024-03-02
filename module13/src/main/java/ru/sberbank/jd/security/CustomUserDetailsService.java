package ru.sberbank.jd.security;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private Map<String, CustomUserDetails> users = new HashMap<>();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CustomUserDetailsService() {
        users.put("student1", new CustomUserDetails("student1", passwordEncoder.encode("password1"), "ROLE_STUDENT"));
        users.put("teacher1", new CustomUserDetails("teacher1", passwordEncoder.encode("password2"), "ROLE_TEACHER"));
        users.put("director", new CustomUserDetails("director", passwordEncoder.encode("password3"), "ROLE_DIRECTOR"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (users.containsKey(username)) {
            return users.get(username);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
