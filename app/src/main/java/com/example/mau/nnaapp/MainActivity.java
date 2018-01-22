package com.example.mau.nnaapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.aboutOption:
                Intent toAbout = new Intent(this, AboutActivity.class);
                startActivity(toAbout);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.imageNanachi);
        final int[] sounds = {R.raw.nnaa001, R.raw.nnaa002, R.raw.nnaa003, R.raw.nnaa004, R.raw.nnaa005, R.raw.nnaa006, R.raw.nnaa007, R.raw.nnaa008, R.raw.nnaa009,
                R.raw.nnaa010, R.raw.nnaa011, R.raw.nnaa012, R.raw.nnaa013, R.raw.nnaa014, R.raw.nnaa015, R.raw.nnaa016 };

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.mipmap.nanachi_2);
                final MediaPlayer mp = MediaPlayer.create(MainActivity.this, sounds[new Random().nextInt(sounds.length)]);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        imageView.setImageResource(R.mipmap.nanachi_1);
                        mp.release();
                    }
                });
            }
        });
    }
}
