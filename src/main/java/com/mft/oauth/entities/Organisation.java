package com.mft.oauth.entities;

import com.mft.general.entities.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "organisations")
@Entity
@SuperBuilder
public class Organisation extends BaseEntity<Integer> {

    public Organisation() {
    }

    @Column(nullable = false)
    private String OrganisationName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "organisation_groups",
            joinColumns = {@JoinColumn(name = "organisation_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private List<Group> groups;

}
