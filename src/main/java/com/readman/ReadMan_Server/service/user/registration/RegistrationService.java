package com.readman.ReadMan_Server.service.user.registration;

import com.readman.ReadMan_Server.model.RegistrationRequestModel;
import com.readman.ReadMan_Server.model.ResponseModel;

public interface RegistrationService {

    ResponseModel<?> registerUser(RegistrationRequestModel registrationRequestModel);

}
