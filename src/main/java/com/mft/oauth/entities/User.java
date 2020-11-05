package com.mft.oauth.entities;


import javax.persistence.*;


import com.mft.general.entities.FUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "users")
@Entity
@SuperBuilder
public class User extends FUser {

    public User() {
    }

    @Column(nullable = false)
    private Integer passWrong;

    private Integer firstName;

    private Integer lastName;

    private Date accountLockDate;

    @JoinColumn(name = "organisation_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Organisation organisation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_groups",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private List<Group> groups;

}