package com.readman.ReadMan_Server.service.user.registration;

import com.readman.ReadMan_Server.collection.User;
import com.readman.ReadMan_Server.model.RegistrationRequestModel;
import com.readman.ReadMan_Server.model.ResponseModel;
import com.readman.ReadMan_Server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    @Override
    public ResponseModel<?> registerUser(RegistrationRequestModel newRegistration) {

        Optional<User> existUser = userRepository.findByUserEmail(newRegistration.getUserEmail());

        if(existUser.isPresent()){
            return ResponseModel.builder()
                    .status(Boolean.FALSE)
                    .message("User Already Exists")
                    .data(existUser)
                    .build();
        }

        User newUser = User.builder()
                .userName(newRegistration.getUserName())
                .userEmail(newRegistration.getUserEmail())
                .userPassword(newRegistration.getUserPassword())
                .build();

        User savedUser = userRepository.save(newUser);

        return ResponseModel.builder()
                .status(Boolean.TRUE)
                .message("Registration Successful")
                .data(savedUser)
                .build();
    }
}
