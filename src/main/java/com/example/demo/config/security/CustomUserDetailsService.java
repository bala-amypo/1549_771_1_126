package com.example.demo.security;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerProfileRepository customerProfileRepository;

    public CustomUserDetailsService(CustomerProfileRepository customerProfileRepository) {
        this.customerProfileRepository = customerProfileRepository;
    }

   @Override
public UserDetails loadUserByUsername(String email)
        throws UsernameNotFoundException {

    CustomerProfile customer = customerProfileRepository
            .findByEmail(email)
            .orElseThrow(() ->
                    new UsernameNotFoundException("User not found: " + email)
            );

    return new org.springframework.security.core.userdetails.User(
            customer.getEmail(),
            customer.getPassword(),   // see NOTE below
            List.of(new SimpleGrantedAuthority("ROLE_" + customer.getRole()))
    );
}

}
