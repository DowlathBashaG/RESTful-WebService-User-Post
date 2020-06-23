package io.dowlath.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.dowlath.rest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
