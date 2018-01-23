package org.bryanzzz.service;

import org.bryanzzz.dto.UserExecution;
import org.bryanzzz.entity.User;

public interface UserService {

    UserExecution userLogin(User user);

}
