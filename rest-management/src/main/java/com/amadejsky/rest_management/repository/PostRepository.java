package com.amadejsky.rest_management.repository;

import com.amadejsky.rest_management.models.Post;
import com.amadejsky.rest_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {


}
