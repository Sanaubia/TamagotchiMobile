package com.example.tamagotchitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, gameEngine.GameOver {

    gameEngine engine = new gameEngine();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.layout0).setOnClickListener(this);
        findViewById(R.id.layout1).setOnClickListener(this);
        findViewById(R.id.layout2).setOnClickListener(this);
        findViewById(R.id.layout3).setOnClickListener(this);
        findViewById(R.id.layout4).setOnClickListener(this);



        engine.setKuuntelija(this);

        engine.startGame();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.layout0):
                engine.feedTama(0);
                break;
            case (R.id.layout1):
                engine.feedTama(1);
                break;
            case (R.id.layout2):
                engine.feedTama(2);
                break;
            case (R.id.layout3):
                engine.feedTama(3);
                break;
            case (R.id.layout4):
                engine.feedTama(4);
                break;

        }

    }
    @Override
    public void send(final Object name) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {


            }
        });
    }

    @Override
    public void gameOverMessage(final String status) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(status.contains("tamagotchi 0")){
                    TextView food = findViewById(R.id.tamagotchi0Food);
                    TextView name = findViewById(R.id.tamagotchi0Name);


                    String nimi = status.substring(0,13);
                    name.setText(nimi);


                    String ruoka = status.substring(15,status.length());
                    food.setText( "Food left: " + ruoka);
                }if(status.contains("tamagotchi 1")){
                    TextView food = findViewById(R.id.tamagotchi1Food);
                    TextView name = findViewById(R.id.tamagotchi1Name);

                    String nimi = status.substring(0,13);
                    name.setText(nimi);

                    String ruoka = status.substring(15,status.length());
                    food.setText( "Food left: " + ruoka);
                }if(status.contains("tamagotchi 2")){
                    TextView name = findViewById(R.id.tamagotchi2Name);
                    TextView food = findViewById(R.id.tamagotchi2Food);

                    String nimi = status.substring(0,13);
                    name.setText(nimi);


                    String ruoka = status.substring(15,status.length());
                    food.setText( "Food left: " + ruoka);
                }if(status.contains("tamagotchi 3")){
                    TextView name = findViewById(R.id.tamagotchi3Name);
                    TextView food = findViewById(R.id.tamagotchi3Food);

                    String nimi = status.substring(0,13);
                    name.setText(nimi);

                    String ruoka = status.substring(15,status.length());
                    food.setText( "Food left: " + ruoka);
                }if(status.contains("tamagotchi 4")){
                    TextView name = findViewById(R.id.tamagotchi4Name);
                    TextView food = findViewById(R.id.tamagotchi4Food);

                    String nimi = status.substring(0,13);
                    name.setText(nimi);

                    String ruoka = status.substring(15,status.length());
                    food.setText( "Food left: " + ruoka);
                }if(status.contains("end")){
                  //  TextView food = findViewById(R.id.tamagotchi0Food);
                   // food.setText(status)
                    openDialog();
                }

            }
        });

    }
    public void openDialog(){
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "Game Over!");
    }






}
