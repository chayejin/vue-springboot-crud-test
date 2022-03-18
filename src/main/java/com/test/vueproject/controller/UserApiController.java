package com.test.vueproject.controller;

import com.test.vueproject.domain.User.User;
import com.test.vueproject.dto.User.UserFindByIdResponseDto;
import com.test.vueproject.dto.User.UserSaveRequestDto;
import com.test.vueproject.rest.ApiResult;
import com.test.vueproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class UserApiController {

    UserService userService;

    @GetMapping("/api/users")
    public ApiResult<List<User>> getAll() {
        List<User> list = userService.userFindAll();

        return ApiResult.<List<User>>builder()
                .data(list)
                .build();
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable("id") Long id) {
        ResponseEntity<?> entity = null;

        try {
            entity = new ResponseEntity<UserFindByIdResponseDto>(userService.userFindById(id), HttpStatus.OK);
        } catch (Exception e) {
            if(e.getMessage() == "User Not Fountd"){
                entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return entity;
    }

    @PostMapping("/api/users/create")
    public ResponseEntity<?> create(@RequestBody final UserSaveRequestDto userSaveRequestDto) {

        try {
            return new ResponseEntity<Long>(userService.userSignUpRequest(userSaveRequestDto), HttpStatus.CREATED);
        } catch (final Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
