package com.example.backend.newsletter;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name="id",
            updatable = false)
    private long id;

    @Column(name = "email",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT")
    public String email;

    public Newsletter(String email) {
        this.email = email;
    }
}