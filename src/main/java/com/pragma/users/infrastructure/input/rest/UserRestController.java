package com.pragma.users.infrastructure.input.rest;

import com.pragma.users.application.dto.UserDto;
import com.pragma.users.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {

    private final IUserHandler userHandler;

    @GetMapping("/email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userHandler.getUserByEmail(email));
    }
    @GetMapping("/{userId}")
    public ResponseEntity getById(@PathVariable int userId) {
        return ResponseEntity.ok(userHandler.getById(userId));
    }

    @PostMapping()
    public ResponseEntity saveUser(@RequestBody UserDto userDto) {
        userHandler.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
