package com.orbisds.hawfinch.users;


import com.orbisds.hawfinch.lang.Lang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users", schema = "public")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String user_id;
    private String name;

    @ManyToMany
    @JoinTable(
            name="langs_enrolled",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "lang_id")
    )
    private Set<Lang> enrolledLangs = new HashSet<>();

    public void enrollLangs(Lang lang) {
        enrolledLangs.add(lang);
    }
}
