package com.groundzero.giftexchange.jwt.service;

import com.groundzero.giftexchange.user.model.UserEntity;
import com.groundzero.giftexchange.user.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JwtUserDetailsService implements UserDetailsService {

  private final UserInfoRepository userInfoRepository;

  public JwtUserDetailsService(UserInfoRepository userInfoRepository) {
    this.userInfoRepository = userInfoRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity = userInfoRepository.findByUsername(username);
    if (userEntity == null) {
      throw new UsernameNotFoundException("Username not found");
    }

    return new User(userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>());
  }
}
