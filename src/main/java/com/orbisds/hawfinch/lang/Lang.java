package com.orbisds.hawfinch.lang;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orbisds.hawfinch.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="langs", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lang {

    @Id
    private String lang_id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledLangs")
    private Set<User> users = new HashSet<>();
}
