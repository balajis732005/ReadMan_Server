package com.readman.ReadMan_Server.service.user.authentication;

import com.readman.ReadMan_Server.model.AuthenticationRequestModel;
import com.readman.ReadMan_Server.model.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    ResponseModel<?> authenticateUser(AuthenticationRequestModel authenticationRequestModel);

}
