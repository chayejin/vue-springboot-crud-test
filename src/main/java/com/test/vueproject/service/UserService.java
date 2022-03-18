package com.test.vueproject.service;

import com.test.vueproject.domain.User.User;
import com.test.vueproject.domain.User.UserRepository;
import com.test.vueproject.dto.User.UserFindByIdResponseDto;
import com.test.vueproject.dto.User.UserSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Transactional
    public Long userSignUpRequest(UserSaveRequestDto dto) {
        return userRepository.save(dto.toEntity()).getId();
    }

    public List<User> userFindAll(){
        List<User> list = userRepository.findAll();

        return list;
    }

    public UserFindByIdResponseDto userFindById(Long id) throws Exception{
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return new UserFindByIdResponseDto(user.get());
        }else{
            throw new Exception("User Not Found");
        }
    }
}
