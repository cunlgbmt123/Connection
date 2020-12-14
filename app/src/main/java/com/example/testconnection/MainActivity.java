package com.example.testconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    Button btnShow,btnOk;
    EditText txtUser, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = findViewById(R.id.btnShow);
        btnOk = findViewById(R.id.btnOK);
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
                        ResultSet rs = st.executeQuery("select*from Table_Login ");
                        while (rs.next()) {
                            txtUser.setText(rs.getString(1));
                            txtPass.setText(rs.getString(2));

                        }

                    }
                    else {
                        System.out.println("can not login");
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (ConnectionClass.con == null) {
                        new ConnectionClass().setConnection();
                    }
                    if(ConnectionClass.con !=null){
                        Statement st = ConnectionClass.con.createStatement();
                        ResultSet rs = st.executeQuery("select*from Table_Login where Name = '" + txtUser.getText().toString().trim() + "'and Pass='"+txtPass.getText().toString().trim()+"'");
                        while (rs.next()) {
                           acc2();
                        }

                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Can not login",Toast.LENGTH_LONG).show();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Can not login",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });
    }
    public void acc2(){
        Intent intent = new Intent(this,helloGuy.class);
        startActivity(intent);
    }

}