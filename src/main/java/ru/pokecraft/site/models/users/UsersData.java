package ru.pokecraft.site.models.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "userdata")
@Getter@Setter
@NoArgsConstructor
public class UsersData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "userData", cascade = CascadeType.ALL)
    private Long userId;

    private String firstName;
    private String lastName;
    private String thirdName;
    private String phoneNumber;
    private String email;
}
