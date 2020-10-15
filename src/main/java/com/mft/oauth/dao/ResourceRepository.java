package com.mft.oauth.dao;

import com.mft.oauth.entities.Resource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

    @Query(value = "SELECT * FROM resources where resourceType = 'ROLE' " +
            "and id in (select resource_id from Resource_Groups where " +
            "(durationAccess > now() or durationAccess is null) and access = 1 " +
            "and (group_id in (select group_id from user_groups where user_id = :userId) " +
            "or group_id in (select group_id from organisation_groups where organisation_id in " +
            "(select organisation_id from users where id = :userId)))) " +
            "and id not in " +
            "(select resource_id from Resource_Groups " +
            "where (durationAccess > now() or durationAccess is null) and access = 0 " +
            "and (group_id in (select group_id from user_groups where user_id = :userId) " +
            "or group_id in (select group_id from organisation_groups where organisation_id in " +
            "(select organisation_id from users where id = :userId))))", nativeQuery = true)
    List<Resource> findRolesByUserId(Long userId);

}
