package me.hwangyunje.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.hwangyunje.springbootdeveloper.domain.User;
import me.hwangyunje.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()->new IllegalArgumentException(email));
    }
}
