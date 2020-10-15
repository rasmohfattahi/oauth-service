package com.mft.oauth.entities;


import com.mft.general.entities.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "policies")
@Entity
@SuperBuilder
/**
 * this is a hard code table.
 * End user can not insert and update in this table.
 */
public class Policy extends BaseEntity<Integer> {

    public Policy() {
    }

    @Column(nullable = false, updatable = false)
    private String policyName;

    @Column(nullable = false, updatable = false)
    private String defaultValue;

}