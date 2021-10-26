package com.learn.time.time.batch.xmltotxt.model;

import java.io.Serializable;
import java.util.Calendar;
import lombok.Data;

/**
 * Data class.
 *
 * @author Alexey Saenko (alexey.saenko@gmail.com)
 */
@Data
public class Customer implements Serializable {

    private int id;
    private String name;
    private Calendar birthday;
    private int transactions;

    @Override
    public String toString() {
        return String.format(
            "#%s, %s born on %3$tb %3$te, %3$tY, finished %4$s transactions",
            id,
            name,
            birthday.getTime(),
            transactions
        );
    }

}