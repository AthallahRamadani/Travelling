package com.travelling.travelling.controller;

import com.travelling.travelling.model.UserEntity;
import com.travelling.travelling.service.UserService;
import com.travelling.travelling.utils.dto.UserDTO;
import com.travelling.travelling.utils.dto.UserUpdateDTO;
import com.travelling.travelling.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    private ResponseEntity<?> createUser(
            @RequestBody UserDTO request) {
        UserEntity result = userService.create(request);
        return Response.renderJSON(result, "NEW USER CREATED");
    }


    @GetMapping
    private ResponseEntity<?> getAll(
            @PageableDefault Pageable pageable,
            @RequestParam(required = false) String name) {
        return Response.renderJSON(userService.getAll(pageable, name), "SHOW ALL USERS");
    }


    @GetMapping("/{id}")
    private ResponseEntity<?> getById(
             @PathVariable Long id) {
        return Response.renderJSON(userService.getById(id), "SHOW ONE USER BY ID");
    }


    @PutMapping("/{id}")
    private ResponseEntity<?> update(
            @RequestBody UserUpdateDTO request,
            @PathVariable Long id) {
        return Response.renderJSON(userService.update(request, id), "USER UPDATED");
    }


    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(
            @PathVariable Long id) {
        return Response.renderJSON(userService.deleteById(id), "USER DELETED SUCCESSFULLY");
    }
}

