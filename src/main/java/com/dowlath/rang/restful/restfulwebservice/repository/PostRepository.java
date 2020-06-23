package com.dowlath.rang.restful.restfulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dowlath.rang.restful.restfulwebservice.model.Post;
import com.dowlath.rang.restful.restfulwebservice.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{

}
