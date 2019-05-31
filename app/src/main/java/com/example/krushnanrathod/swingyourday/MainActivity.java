package com.example.krushnanrathod.swingyourday;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
        SoundPool sp;
        MediaPlayer mm,m1;
        int explosion=0;
        Random crazy=new Random(  );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );     //SetContentView implements XML directly
        View v=new View(this);
        v.setOnClickListener( this );
        v.setOnLongClickListener( this );
        v.setOnTouchListener( this );
        setContentView( v );
        mm=MediaPlayer.create( this,R.raw.soundtrack );
        m1=MediaPlayer.create( this,R.raw.ringtone );
        sp=new SoundPool( 5,AudioManager.STREAM_MUSIC,0 );          //sound pool is used to play short duration song
        explosion=sp.load( this,R.raw.explosion,1 );
        v.setBackgroundColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265),crazy.nextInt(265))) ;

    }

    @Override
    public void onClick(View v) {
        if (explosion!=0)
        {
            sp.play( explosion,1,1,0,0,1 );
            v.setBackgroundColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265),crazy.nextInt(265))) ;

        }
        Toast.makeText( this, "you clicked on OnclickListener", Toast.LENGTH_SHORT ).show();
    }

    @Override
    public boolean onLongClick(View v) {
        m1.start();
        Toast.makeText( this, "you clicked on OnLongclickListener", Toast.LENGTH_SHORT ).show();

        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mm.start();
        Toast.makeText( this, "you clicked on OnTouchListener", Toast.LENGTH_SHORT ).show();
        return false;
    }
    @Override
    protected void onPause() {
        super.onPause();
        mm.release();
    }

}
