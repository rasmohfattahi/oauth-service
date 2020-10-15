package com.mft.oauth.entities;

import com.mft.general.entities.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "Resource_Groups")
@Entity
@SuperBuilder
public class ResourceGroup extends BaseEntity<Long> {

    public ResourceGroup() {
    }

    @Column(name = "group_id", nullable = false)
    private Integer group;

    @Column(name = "resource_id", nullable = false)
    private Integer resource;

    @Column(nullable = false)
    private boolean access;

    private Date durationAccess;

}
