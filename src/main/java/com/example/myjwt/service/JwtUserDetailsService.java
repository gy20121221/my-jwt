package com.example.myjwt.service;


import com.example.myjwt.model.JwtRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author zhangpeng
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Resource
    private com.example.myjwt.untils.UserDetails userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        for (JwtRequest jwtRequest : userDetails.USER) {
            if (jwtRequest.getUsername().equals(username)) {
                return new User(jwtRequest.getUsername(), BCrypt.hashpw(jwtRequest.getPassword(), BCrypt.gensalt()),
                        new ArrayList<>());
            }
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }

}