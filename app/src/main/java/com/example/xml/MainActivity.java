package com.example.xml;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout BaseLayout;
    Button btn1, btn2, btn3, btn4, btn5, btn6;
    Switch Reserve ;
    DatePicker Calendar;
    TextView restaurantD, Day;
    TextView Choose ;
    Toast Toast;
    String WhatYouEat;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        if ( v == btn1) {
            menu.setHeaderTitle("아침");
            mInflater.inflate(R.menu.menum, menu);
        }
        if ( v == btn2) {
            menu.setHeaderTitle("점심");
            mInflater.inflate(R.menu.menul, menu);
        }
        if ( v == btn3) {
            menu.setHeaderTitle("아침");
            mInflater.inflate(R.menu.menud, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.Porksoup :
                Toast.makeText(this, "국밥을 선택하셨습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Misosoup :
                Toast.makeText(this, "된장찌개를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Kimchisoup :
                Toast.makeText(this, "김치찌개를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Pasta :
                Toast.makeText(this, "파스타를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Pizza :
                Toast.makeText(this, "피자를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Hamburger :
                Toast.makeText(this, "햄버거를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Steak :
                Toast.makeText(this, "스테이크를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lobster :
                Toast.makeText(this, "랍스터를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Bibimbab :
                Toast.makeText(this, "비빔밥을 선택하셨습니다", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menubefore, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        Toast toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG);

        switch(item.getItemId())
        {
            case R.id.bef1:
                toast.setText("Option Menu 1");
                break;
            case R.id.bef2:
                toast.setText("Option Menu 2");
                break;

        }

        toast.show();

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Restaurant Reservation");
        BaseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        restaurantD = (TextView) findViewById(R.id.reservation);
        btn1 = (Button) findViewById(R.id.MenuBreakfast);
        registerForContextMenu(btn1);
        btn2 = (Button) findViewById(R.id.MenuLunch);
        registerForContextMenu(btn2);
        btn3 = (Button) findViewById(R.id.MenuDinner);
        registerForContextMenu(btn3);
        btn4 = (Button) findViewById(R.id.Confirm);
        btn5 = (Button) findViewById(R.id.bef1);
        btn6 = (Button) findViewById(R.id.bef2);
        Reserve = (Switch) findViewById(R.id.ResSwitch);
        Calendar = (DatePicker) findViewById(R.id.calendar);
        Day = (TextView) findViewById(R.id.txtdate);
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);
        Calendar.setVisibility(View.INVISIBLE);

        //


        Calendar.init(Calendar.getYear(), Calendar.getMonth(), Calendar.getDayOfMonth(), new DatePicker.OnDateChangedListener(){
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Day.setText(String.format("%d%d%d", year, monthOfYear + 1, dayOfMonth));
            }
        });
        findViewById(R.id.Confirm).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String result = String.format("%d년 %d월 %d일 ", Calendar.getYear(), Calendar.getMonth()+1, Calendar.getDayOfMonth());
                Toast.makeText(MainActivity.this, result +"로 예약되었습니다.", Toast.LENGTH_SHORT).show();

            }
        });

        //
        Reserve.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (Reserve.isChecked()) {
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                    btn3.setVisibility(View.VISIBLE);
                    btn4.setVisibility(View.VISIBLE);
                    Calendar.setVisibility(View.VISIBLE);
                }
                else{
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                    btn3.setVisibility(View.INVISIBLE);
                    btn4.setVisibility(View.INVISIBLE);
                    Calendar.setVisibility(View.INVISIBLE);
                }
            }
        });

//


/*
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
    }*/
}}