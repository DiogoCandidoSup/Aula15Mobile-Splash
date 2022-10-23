package br.ulbra.aula15telasplash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity
{
    RotateAnimation rotate;

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        logo = (ImageView) findViewById(R.id.logo);

        rotate = new RotateAnimation(0, 300);
        rotate.setDuration(2000);
        logo.startAnimation(rotate);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                mostrarMainActivity();
            }
        }, 2000);
    }

    private void mostrarMainActivity()
    {
        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);

        finish();
    }
}