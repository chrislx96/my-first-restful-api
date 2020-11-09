package com.chris.demo.controllers;

import com.chris.demo.dtos.user.UserGetDto;
import com.chris.demo.dtos.user.UserPostDto;
import com.chris.demo.dtos.user.UserPutDto;
import com.chris.demo.entities.User;
import com.chris.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserGetDto> add(@RequestBody UserPostDto userPostDto) {
        UserGetDto userGetDto = userService.create(userPostDto);
        return ResponseEntity.ok(userGetDto);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> userList = userService.getAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserGetDto> findById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @GetMapping(value = "/search", params ="firstName")
    public ResponseEntity<List<UserGetDto>> findByFirstName(@RequestParam(name="firstName") String firstName) {
        return ResponseEntity.ok(userService.findByFirstName(firstName));
    }

    @GetMapping(value = "/search", params ="lastName")
    public ResponseEntity<List<UserGetDto>> findByLastName(@RequestParam(name="lastName") String lastName) {
        return ResponseEntity.ok(userService.findByLastName(lastName));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserGetDto> update(@PathVariable UUID userId, @RequestBody UserPutDto userPutDto) {
        return ResponseEntity.ok(userService.update(userId, userPutDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity delete(@PathVariable UUID userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}
