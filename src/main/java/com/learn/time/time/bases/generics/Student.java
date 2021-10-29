package com.learn.time.time.bases.generics;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends Human {
    private String group;
}
