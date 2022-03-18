package com.test.vueproject;

import com.test.vueproject.dto.User.UserSaveRequestDto;
import com.test.vueproject.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserApiControllerTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        UserSaveRequestDto userSaveRequestDto = new UserSaveRequestDto();
        userSaveRequestDto.setName("yejin");
        userSaveRequestDto.setPassword("testPassword");

        Long userId = userService.userSignUpRequest(userSaveRequestDto);

        System.out.println(userId);

    }
}
