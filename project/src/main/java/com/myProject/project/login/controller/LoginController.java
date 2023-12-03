package com.myProject.project.login.controller;

import com.myProject.project.common.libs.BaseController;
import com.myProject.project.common.libs.RestResponse;
import com.myProject.project.login.dto.AppUserDto;
import com.myProject.project.login.services.LoginService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class LoginController extends BaseController {

    private LoginService userService;

    @PostMapping
    public ResponseEntity<RestResponse<AppUserDto>> createUser(@RequestBody AppUserDto user) {
        AppUserDto savedUser = userService.createUser(user);
        return ok(newRestResponse(user));
    }

    @GetMapping("{email}")
    public ResponseEntity<RestResponse<AppUserDto>> getUserByEmail(@PathVariable("email") String e_mail) {
        AppUserDto user = userService.getUserByEmail(e_mail);
        return ok(newRestResponse(user));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<AppUserDto>>> getAllUsers() {
        List<AppUserDto> users = userService.getAllUsers();
        return ok(newRestResponse(users));
    }

    @PutMapping("{appUserId}")
    public ResponseEntity<RestResponse<AppUserDto>> saveOrUpdateUser(@PathVariable("appUserId") Long userId,
                                                                     @RequestBody AppUserDto user) {
        AppUserDto updatedUser = userService.saveOrUpdateUser(user);
        return ok(newRestResponse(updatedUser));
    }
}