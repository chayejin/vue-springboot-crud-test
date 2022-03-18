package com.test.vueproject.dto.User;

import com.test.vueproject.domain.User.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserSaveRequestDto {

    private String name;
    private String password;

    public User toEntity() {
        return User.builder()
                .name(name)
                .password(password)
                .build();
    }

}
