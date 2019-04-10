package com.example.tandeptrai.testapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar sbOne, sbTwo, sbThree;
    ImageButton ibtnPlay;
    int sodiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        sbOne.setEnabled(false);
//        sbTwo.setEnabled(false);
//        sbThree.setEnabled(false);
        AnhXa();

        txtDiem.setText(sodiem + "");

        final CountDownTimer cdt = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                sbOne.setProgress(sbOne.getProgress() + one);
                sbTwo.setProgress(sbTwo.getProgress() + two);
                sbThree.setProgress(sbThree.getProgress() + three);
                if(sbOne.getProgress() >= sbOne.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One win", Toast.LENGTH_SHORT).show();
                    if(cbOne.isChecked()){
                        sodiem+=10;
                        Toast.makeText(MainActivity.this, "Tiền về", Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem -= 5;
                        Toast.makeText(MainActivity.this, "Tach", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(sodiem + "");
                    EnableChekcbox();
                }
                if(sbTwo.getProgress() >= sbTwo.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Two win", Toast.LENGTH_SHORT).show();
                    if(cbTwo.isChecked()){
                        sodiem+=10;
                        Toast.makeText(MainActivity.this, "Tiền về", Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem -= 5;
                        Toast.makeText(MainActivity.this, "Tach", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(sodiem + "");
                    EnableChekcbox();
                }
                if(sbThree.getProgress() >= sbThree.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Three win", Toast.LENGTH_SHORT).show();
                    if(cbThree.isChecked()){
                        sodiem+=10;
                        Toast.makeText(MainActivity.this, "Tiền về", Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem -= 5;
                        Toast.makeText(MainActivity.this, "Tach", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(sodiem + "");
                    EnableChekcbox();
                }
            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){
                    sbOne.setProgress(0);
                    sbTwo.setProgress(0);
                    sbThree.setProgress(0);
                    ibtnPlay.setVisibility(View.INVISIBLE);
                    cdt.start();
                    DisableCheckbox();
                }else{
                    Toast.makeText(MainActivity.this, "đặt đê", Toast.LENGTH_SHORT).show();
                }


            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }

            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });

    }

    private void EnableChekcbox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }

    private void DisableCheckbox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }

    private void AnhXa(){
        txtDiem = (TextView) findViewById(R.id.txtViewDiem);
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);
        sbOne = (SeekBar) findViewById(R.id.seekbarOne);
        sbTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        sbThree = (SeekBar) findViewById(R.id.seekbarThree);
        ibtnPlay = (ImageButton) findViewById(R.id.btnPlay);
     }
}
