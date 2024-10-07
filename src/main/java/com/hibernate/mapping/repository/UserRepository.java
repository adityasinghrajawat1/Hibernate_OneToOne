package com.hibernate.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.mapping.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
