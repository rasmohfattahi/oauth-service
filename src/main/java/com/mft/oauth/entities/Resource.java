package com.mft.oauth.entities;

import com.mft.general.entities.BaseEntity;
import com.mft.oauth.enums.ResourceType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "resources")
@Entity
@SuperBuilder
public class Resource extends BaseEntity<Integer> {

    public Resource() {
    }

    @Column(nullable = false)
    private String resourceName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

}
