package org.bryanzzz.dao;

import org.bryanzzz.entity.User;

public interface UserDao {

    User queryByUsername(String username);

    User queryById(long userId);
}
