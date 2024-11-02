package com.readman.ReadMan_Server.service.user.registration;

import com.readman.ReadMan_Server.collection.User;
import com.readman.ReadMan_Server.model.ResponseModel;
import com.readman.ReadMan_Server.model.UserModel;
import com.readman.ReadMan_Server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    @Override
    public ResponseModel<?> registerUser(UserModel user) {

        User newUser = User.builder()
                .userName(user.getUserName())
                .userEmail(user.getUserEmail())
                .userPassword(user.getUserPassword())
                .build();

        if(userRepository.existsByUserEmail(user.getUserEmail())){
            return ResponseModel.builder()
                    .status(false)
                    .message("User Already Exists")
                    .data(user)
                    .build();
        }

        userRepository.save(newUser);

        return ResponseModel.builder()
                .status(true)
                .message("Registration Successful")
                .data(user)
                .build();
    }
}
