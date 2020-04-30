package com.vaibhavmojidra.demo;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    String ip = "xxx.xxx.xxx.xxx";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "database_name";
    String un = "user";
    String password = "password";

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL;
        try {
            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"+"databaseName=" + db + ";user=" + un + ";password="+ password + ";";
            conn = DriverManager.getConnection(ConnURL);
        }
        catch (SQLException se)
        {
            Log.e("Error 1: ", se.getMessage());
        }
        catch (ClassNotFoundException e) {
        }
        catch (Exception e) {
            Log.e("Error 2:", e.getMessage());
        }
        return conn;
    }
}