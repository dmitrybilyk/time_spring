package com.learn.time.time.bases.generics.walproject;

import lombok.Data;

@Data
public class Buyer {
    private String name;

    public Buyer(String name) {
        this.name = name;
    }
}
