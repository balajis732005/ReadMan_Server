package com.readman.ReadMan_Server.service.user.authentication;

import com.readman.ReadMan_Server.collection.User;
import com.readman.ReadMan_Server.model.AuthenticationRequestModel;
import com.readman.ReadMan_Server.model.AuthenticationResponseModel;
import com.readman.ReadMan_Server.model.ResponseModel;
import com.readman.ReadMan_Server.repository.UserRepository;
import com.readman.ReadMan_Server.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Override
    public ResponseModel<?> authenticateUser(AuthenticationRequestModel authenticationRequestModel) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequestModel.getUserEmail(),
                        authenticationRequestModel.getUserPassword()
                )
        );

        User authUser = userRepository.findByUserEmail(authenticationRequestModel.getUserEmail());

        var user = (User)auth.getPrincipal();
        String generatedJwtToken = jwtService.generateToken(new HashMap<>(),user);

        AuthenticationResponseModel authResponse = AuthenticationResponseModel.builder()
                .userId(authUser.getUserId())
                .peopleName(authUser.getPeopleName())
                .userEmail(authUser.getUserEmail())
                .jwtToken(generatedJwtToken)
                .build();

        return ResponseModel.builder()
                .status(Boolean.TRUE)
                .message("Authentication Successful")
                .data(authResponse)
                .build();
    }
}
