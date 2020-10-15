package com.mft.general.repository;

import com.mft.general.entities.BaseEntity;

import java.io.Serializable;

public interface GenericRepository<T extends BaseEntity<PK>, PK extends Serializable> {
}