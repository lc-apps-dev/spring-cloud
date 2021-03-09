package pl.lcappsdev.restfulwebservices.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.lcappsdev.restfulwebservices.model.Post;

@Repository
public interface PostRepository extends JpaRepository <Post, Integer>{

}
