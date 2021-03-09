package pl.lcappsdev.restfulwebservices.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.lcappsdev.restfulwebservices.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{



}
