package com.microservices.User.services;

import com.microservices.User.models.UserModel;
import com.microservices.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public UserModel save(UserModel userModel) {
    return this.userRepository.save(userModel);
  }
}
