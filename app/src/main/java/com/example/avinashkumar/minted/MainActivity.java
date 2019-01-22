package com.example.avinashkumar.minted;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //private SoundPool soundPool=new SoundPool(2, AudioManager.STREAM_MUSIC,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.small_beep_sms);
        Button rollButton;
        rollButton=(Button) findViewById(R.id.roll_button);
        final ImageView leftDice;
        leftDice=(ImageView)findViewById(R.id.image_leftDice);
        final ImageView rightDice;
        rightDice=(ImageView)findViewById(R.id.image_rightDice);
        final int[] diceArray={
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };


        //final int soundID=soundPool.load(getApplicationContext(),R.raw.note1_c,1);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.small_beep_sms);
                //mediaPlayer.start(); // no need to call prepare(); create() does that for you
                //soundPool.play(soundID,1.0f,1.0f,1,1,1.0f);
                mediaPlayer.start();
                Log.d("Dicee", "the button got pressed");

                Random randomNumberGenerator= new Random();
                int number=randomNumberGenerator.nextInt(6);
                Log.d("Dicee","The random number generated is "+number);
                leftDice.setImageResource(diceArray[number]);
                number=randomNumberGenerator.nextInt(6);
                rightDice.setImageResource(diceArray[number]);
            }
        });
    }
}
