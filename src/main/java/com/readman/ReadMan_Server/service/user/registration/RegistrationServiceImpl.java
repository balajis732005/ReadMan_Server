package com.readman.ReadMan_Server.service.user.registration;

import com.readman.ReadMan_Server.collection.User;
import com.readman.ReadMan_Server.model.RegistrationRequestModel;
import com.readman.ReadMan_Server.model.RegistrationResponseModel;
import com.readman.ReadMan_Server.model.ResponseModel;
import com.readman.ReadMan_Server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseModel<?> registerUser(RegistrationRequestModel newRegistration) {

        User existUser = userRepository.findByUserEmail(newRegistration.getUserEmail());

        if(existUser!=null){
            return ResponseModel.builder()
                    .status(Boolean.FALSE)
                    .message("User Already Exists")
                    .data(existUser)
                    .build();
        }

        User newUser = User.builder()
                .peopleName(newRegistration.getPeopleName())
                .userEmail(newRegistration.getUserEmail())
                .userPassword(passwordEncoder.encode(newRegistration.getUserPassword()))
                .build();

        User savedUser = userRepository.save(newUser);

        RegistrationResponseModel regUser = RegistrationResponseModel.builder()
                .userId(savedUser.getUserId())
                .peopleName(savedUser.getPeopleName())
                .userEmail(savedUser.getUserEmail())
                .build();

        return ResponseModel.builder()
                .status(Boolean.TRUE)
                .message("Registration Successful")
                .data(regUser)
                .build();
    }
}
