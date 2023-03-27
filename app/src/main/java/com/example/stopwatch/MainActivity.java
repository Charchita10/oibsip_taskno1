package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;


public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean running;
    private long pauseoffset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer=findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

            }
        });}

        public void startchrono(View v) {
            if (!running) {
                chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
                chronometer.start();
                running = true;
            }
        }

        public void pausechrono(View v) {
            if (running) {
                chronometer.stop();
                pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                running = false;
            }
        }

        public void resetchrono(View v) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseoffset = 0;
        }
    }
