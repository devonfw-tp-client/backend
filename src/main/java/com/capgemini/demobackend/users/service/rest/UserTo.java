package com.capgemini.demobackend.users.service.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

public class UserTo {
  private final Long id;

  @NotNull
  private final String name;

  @Email
  @NotNull
  private final String email;

  @JsonCreator
  public UserTo(@JsonProperty("id") Long id,
                @JsonProperty("name") String name,
                @JsonProperty("email") String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}
