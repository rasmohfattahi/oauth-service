package com.mft.oauth.dao;

import com.mft.oauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select e from User e where e.username=:userName")
    Optional<User> findByUsername(@Param("userName") String userName);
}
