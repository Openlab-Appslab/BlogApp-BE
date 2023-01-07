package com.example.backend.likes;

import java.io.Serializable;

public class LikeId implements Serializable {

private long userid;

private long blogid;

    public LikeId(long userid, long blogid) {
        this.userid = userid;
        this.blogid = blogid;
    }
}
