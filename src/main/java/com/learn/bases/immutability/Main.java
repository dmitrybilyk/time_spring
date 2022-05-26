package com.learn.bases.immutability;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        final List<String> strings3 = new ArrayList<>();
        final List<String> strings2 = new ArrayList<>();
        final List<String> strings = strings2;
        strings.add("43454");

        String password = "pass";
        password = "pass77";
        criticalMethod(password);
//        strings = strings3;
//        assertEquals(0, strings.size());
//        strings.add("baeldung");
//        assertEquals(0, strings.size());
    }

    static void criticalMethod(String userName) {
        // perform security checks
        if (!isAlphaNumeric(userName)) {
            throw new SecurityException();
        }
//
//        // do some secondary tasks
//        initializeDatabase();
//
//        // critical task
        String s = "dfdf";
// connection.executeUpdate("UPDATE Customers SET Status = 'Active' " +
// " WHERE UserName = '" + userName + "'");
    }

    private static boolean isAlphaNumeric(String userName) {
        userName = "new value";
        return true;
    }
}
