package com.example.demo.Security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class CutomeUserDetailsService implements UserDetailsService{

	 private UserRepository userRepository;


    @Autowired
    public void CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user using the repository method
        User user = userRepository.findByUsername(username);

        // If user is null, throw the UsernameNotFoundException
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Return the UserDetails (you might need to map your User entity to UserDetails)
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        // Assuming the User class has roles, map those to authorities/roles
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
