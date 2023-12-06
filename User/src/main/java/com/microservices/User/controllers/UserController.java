package com.microservices.User.controllers;

import com.microservices.User.dtos.UserRecordDto;
import com.microservices.User.models.UserModel;
import com.microservices.User.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/users")
  public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
      UserModel newUser = new UserModel();

      newUser.setName(userRecordDto.name());
      newUser.setEmail(userRecordDto.email());
      return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(newUser));
  }

}
