package com.learn.other;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class FunctionCheck
{
    private final String url = "jdbc:postgresql://10.17.2.32:5432/wfo_core";
    private final String user = "wfo_user";
    private final String password = "wfo_pass";
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
//        Connection conn = null;
        Connection conn = null;
        try {

            String url = "jdbc:postgresql://10.17.2.32/test";
            Properties props = new Properties();
            props.setProperty("user", "wfo_user");
            props.setProperty("password", "wfo_pass");
            props.setProperty("ssl", "true");
            conn = DriverManager.getConnection(url, props);

//            String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
//            Connection conn = DriverManager.getConnection(url);

//            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        FunctionCheck app = new FunctionCheck();
        Connection con = app.connect();
        try
        {
            /* CallableStatement stmt = con.prepareCall("{call helloworld()}"); */
            PreparedStatement stmt = con.prepareStatement("call dmytropavelprocedure()");
            stmt.execute();
            System.out.println("Stored Procedure executed successfully");
        }
        catch(Exception err)
        {
            System.out.println("An error has occurred.");
            System.out.println("See full details below.");
            err.printStackTrace();
        }
    }
}