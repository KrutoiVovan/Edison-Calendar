package com.tut.vivacloud.model.repository;

import com.tut.vivacloud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository
                extends CrudRepository<User, String> {
}
