package com.example.testconnection;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class ConnectionClass {

    public static Connection con;
    public void setConnection()
    {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String ip = "172.20.10.2";
            String url = "jdbc:jtds:sqlserver://"+ip+";instance=SQLEXPRESS;user=test;password=161020;databasename=testLogin";
            Object newInstance = Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection(url);
            Log.e("ASK", "setConnection called" );
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
