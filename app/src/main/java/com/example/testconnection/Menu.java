package com.example.testconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Menu extends AppCompatActivity {
    private CheckBox banhxeo, bunbo , goicuon, banhmi;
    private Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        banhxeo = (CheckBox) findViewById(R.id.banhxeo);
        bunbo = (CheckBox) findViewById(R.id.bunbo);
        goicuon = (CheckBox) findViewById(R.id.goicuon);
        banhmi = (CheckBox) findViewById(R.id.banhmi);
        order = (Button) findViewById(R.id.goimon);


        order.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double atm = 0;
                StringBuilder kq = new StringBuilder();
                kq.append("Món ăn được gọi *** The dish you just ordered is: ");
                if(banhxeo.isChecked())
                {
                    kq.append("\n\t - Bánh xèo : 50K");
                    atm += 50000;
                }
                if(bunbo.isChecked())
                {
                    kq.append("\n\t - Bún bò : 75K");
                    atm += 75000;
                }
                if(goicuon.isChecked())
                {
                    kq.append("\n\t - Gỏi cuốn : 30K");
                    atm += 30000;
                }
                if(banhmi.isChecked())
                {
                    kq.append("\n\t - Bánh Mì : 20K");
                    atm += 20000;
                }
                DecimalFormat tien = new DecimalFormat("#,##0.00");
                String sotien = tien.format(atm);
                kq.append("\n\t ==> Tổng Thành Tiền Là: "+ sotien + "VNĐ");
                Toast.makeText(getApplicationContext(), kq.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}