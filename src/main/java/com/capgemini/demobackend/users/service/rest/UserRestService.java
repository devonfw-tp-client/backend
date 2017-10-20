package com.capgemini.demobackend.users.service.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("services/rest/v1")
@RestController
public class UserRestService {
  private final AtomicInteger sequencer = new AtomicInteger(0);
  private final Map<Long, UserTo> users = new ConcurrentHashMap<>();

  public UserRestService() {
    addNewUser("Max Mustermann", "max.mustermann@example.com");
    addNewUser("John Example", "john@example.com");
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public Collection<UserTo> getAll() {
    return users.values();
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public ResponseEntity<UserTo> get(@PathVariable("id") Long userId) {
    if (userId != null && users.containsKey(userId)) {
      return ResponseEntity.ok(users.get(userId));
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public ResponseEntity<UserTo> save(@RequestBody @Valid UserTo user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    final Long userId = user.getId();
    if (userId != null) {
      if (users.containsKey(userId)) {
        users.put(userId, user);
        return ResponseEntity.ok(user);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } else {
      return ResponseEntity.ok(addNewUser(user.getName(), user.getEmail()));
    }
  }

  private UserTo addNewUser(String name, String email) {
    UserTo user = new UserTo((long) sequencer.incrementAndGet(), name, email);
    users.put(user.getId(), user);
    return user;
  }
}
