package com.example.backend.likes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(LikeId.class)
public class Likes {

    @Id
    private long userid;

    @Id
    private long blogid;
}
