package com.readman.ReadMan_Server.service.user.registration;

import com.readman.ReadMan_Server.model.ResponseModel;
import com.readman.ReadMan_Server.model.UserModel;

public interface RegistrationService {

    ResponseModel<?> registerUser(UserModel user);

}
