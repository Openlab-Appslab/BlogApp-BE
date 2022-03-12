package com.blogplex.blogplexbe.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
//import java.util.Collection;
import static javax.persistence.GenerationType.SEQUENCE;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user",
    uniqueConstraints = {
        @UniqueConstraint(name="user_email_unique", columnNames = "email")
    }
)
public class User {

    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize =  1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "email",
            columnDefinition = "text",
            nullable = false

    )
    private String email;

    @Column(
            name = "nickname",
            columnDefinition = "text",
            nullable = false
    )
    private String nickname;

    @Column(
            name = "password",
            columnDefinition = "text",
            nullable = false
    )
    private String password;


    }


