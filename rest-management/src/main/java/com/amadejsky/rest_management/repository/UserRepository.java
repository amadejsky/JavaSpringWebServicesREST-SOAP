package com.amadejsky.rest_management.repository;

import com.amadejsky.rest_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
