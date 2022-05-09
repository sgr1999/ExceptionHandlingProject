package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blog.entites.*;


public interface UserRepository extends JpaRepository<User,Long>{

}
