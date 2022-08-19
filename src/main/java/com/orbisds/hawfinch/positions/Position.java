package com.orbisds.hawfinch.positions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orbisds.hawfinch.lang.Lang;
import com.orbisds.hawfinch.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="positions", schema = "public")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Position {

    @Id
    private String position_id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "position")
    private Set<User> users = new HashSet<>();

}
