package com.mft.oauth.dao;

import com.mft.oauth.entities.ResourceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResourceGroupRepository extends JpaRepository<ResourceGroup, Long> {
}