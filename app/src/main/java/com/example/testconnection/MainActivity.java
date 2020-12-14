package com.example.testconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    Button btnShow;
    EditText txtUser, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = findViewById(R.id.btnShow);
        txtUser = findViewById(R.id.editText);
        txtPass = findViewById(R.id.editText2);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (ConnectionClass.con == null) {
                        new ConnectionClass().setConnection();
                    }
                    if(ConnectionClass.con !=null){
                        Statement st = ConnectionClass.con.createStatement();
                        ResultSet rs = st.executeQuery("select*from Table_Login");
                        while (rs.next()) {
                            txtUser.setText(rs.getString(1));
                            txtPass.setText(rs.getString(2));
                        }
                    }
                    else {
                        txtUser.setText("nothing to show");
                        txtPass.setText("nothing to show");
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}