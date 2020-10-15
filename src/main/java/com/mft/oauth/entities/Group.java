package com.mft.oauth.entities;

import com.mft.general.entities.BaseEntity;
import com.mft.oauth.enums.GroupType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "groups")
@Entity
@SuperBuilder
public class Group extends BaseEntity<Integer> {

    public Group() {
    }

    @Column(nullable = false)
    private String groupName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GroupType groupType;

    private Integer specific_id;

}
