package com.example.magazine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView android_phone, ios_phone;
    RadioButton radio_map, radio_nall, radio_qr;
    CheckBox check_home, check_gift;
    Button btnReady;

    String tolemTuri, jetkizuText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android_phone = findViewById(R.id.android_phone);
        ios_phone = findViewById(R.id.ios_phone);

        radio_map = findViewById(R.id.radio_map);
        radio_nall = findViewById(R.id.radio_nall);
        radio_qr = findViewById(R.id.radio_qr);

        check_home = findViewById(R.id.check_home);
        check_gift = findViewById(R.id.check_gift);

        btnReady = findViewById(R.id.btnReady);


        registerForContextMenu(android_phone);
        registerForContextMenu(ios_phone);

        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_map.isChecked()){
                    tolemTuri = "Через банковскую карту";
                }else if(radio_nall.isChecked()){
                    tolemTuri = "Наличными";
                }else{
                    tolemTuri = "с qr кодом ";
                }

                if (check_gift.isChecked()){
                    jetkizuText = "Подарком";
                }

                if (check_home.isChecked()){
                    jetkizuText = "Доставка на дом";
                }

                String res = "Android: " + android_phone.getText() + "\n" +
                             "ios: " + ios_phone.getText() + "\n" +
                             "Способ оплаты: " + tolemTuri + "\n" +
                             "Способ Доставки: " + jetkizuText;

                Toast.makeText(MainActivity.this, res, Toast.LENGTH_LONG).show();

            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if (v == android_phone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);
        }
        if(v == ios_phone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu, menu);
        }


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.sam_phone:
                android_phone.setText("Samsung");
                break;

            case R.id.mi_phone:
                android_phone.setText("Mi9");
                break;

            case R.id.xiaomi_phone:
                android_phone.setText("Xiaomi");
                break;

            case R.id.huawei_phone:
                android_phone.setText("Huawei");
                break;



            case R.id.iPhone11:
                ios_phone.setText("Iphone 11");
                break;

            case R.id.iPhone11Pro:
                ios_phone.setText("Iphone 11 Pro");
                break;

            case R.id.iPhone6sPlus:
                ios_phone.setText("Iphone 6s Plus");
                break;

            case R.id.iPhone13ProMax:
                ios_phone.setText("Iphone 13 Pro Max");
                break;

            case R.id.iPhoneX:
                ios_phone.setText("Iphone X");
                break;
        }

        return super.onContextItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_set:
                Toast.makeText(this, "Setting menu basildi", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu basildi", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_save:
                Toast.makeText(this, "Save menu basildi", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu basildi", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}