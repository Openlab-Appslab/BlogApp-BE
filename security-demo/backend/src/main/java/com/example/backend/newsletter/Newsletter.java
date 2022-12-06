package com.example.backend.newsletter;


import javax.persistence.*;

@Entity
public class Newsletter {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(
                name="id",
                updatable = false
        )
        private long id;

        @Column(
                name = "email",
                nullable = false,
                unique = true,
                columnDefinition = "TEXT"
        )
    public String email;

        public Newsletter(long id, String email) {
                this.id = id;
                this.email = email;
        }
        private long getId(){return id; }

        public String getEmail(){return email; }
}
