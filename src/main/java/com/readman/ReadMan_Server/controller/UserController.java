package com.readman.ReadMan_Server.controller;

import com.readman.ReadMan_Server.model.AuthenticationRequestModel;
import com.readman.ReadMan_Server.model.RegistrationRequestModel;
import com.readman.ReadMan_Server.model.ResponseModel;
import com.readman.ReadMan_Server.service.user.authentication.AuthenticationService;
import com.readman.ReadMan_Server.service.user.registration.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/read-man")
@RequiredArgsConstructor
public class UserController {

    private final RegistrationService registrationService;
    private final AuthenticationService authenticationService;

    @GetMapping("/test-api")
    public ResponseEntity<String> testApi(){
        return ResponseEntity.ok("SpringSecurity Jwt Validation is working correctly");
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseModel<?>> registrationProcess(
            @RequestBody RegistrationRequestModel registrationRequestModel
            ) {
        return ResponseEntity.ok(registrationService.registerUser(registrationRequestModel));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseModel<?>> authenticationProcess(
            @RequestBody AuthenticationRequestModel authenticationRequestModel
            ) {
        return ResponseEntity.ok(authenticationService.authenticateUser(authenticationRequestModel));
    }
}
