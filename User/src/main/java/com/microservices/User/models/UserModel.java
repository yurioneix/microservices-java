package com.microservices.User.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "USERS")
public class UserModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID userID;
  private String name;
  private String Email;

  public UUID getUserID() {
    return userID;
  }

  public void setUserID(UUID userID) {
    this.userID = userID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }
}
