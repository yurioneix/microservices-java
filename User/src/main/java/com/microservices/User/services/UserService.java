package com.microservices.User.services;

import com.microservices.User.models.UserModel;
import com.microservices.User.producers.UserProducer;
import com.microservices.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final UserProducer userProducer;

  @Autowired
  public UserService(UserRepository userRepository, UserProducer userProducer) {
    this.userRepository = userRepository;
    this.userProducer = userProducer;
  }

  @Transactional
  public UserModel save(UserModel userModel) {
    UserModel newUser = userRepository.save(userModel);
    userProducer.publishEmailMessage(userModel);
    return newUser;
  }
}
