package com.orbisds.hawfinch.lang;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
