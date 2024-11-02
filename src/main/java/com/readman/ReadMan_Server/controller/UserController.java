package com.readman.ReadMan_Server.controller;

import com.readman.ReadMan_Server.model.RegistrationRequestModel;
import com.readman.ReadMan_Server.model.ResponseModel;
import com.readman.ReadMan_Server.service.user.registration.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/read-man")
@RequiredArgsConstructor
public class UserController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<ResponseModel<?>> registrationProcess(
            @RequestBody RegistrationRequestModel registrationRequestModel
            ) {
        return ResponseEntity.ok(registrationService.registerUser(registrationRequestModel));
    }
}
