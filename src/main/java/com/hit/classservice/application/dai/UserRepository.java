package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.User;

public interface UserRepository {

  User findById(String id);

}
