package com.korkeep.s_talk;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new splash(), 500);
    }

    private class splash implements Runnable{
        public void run(){
            startActivity(new Intent(getApplication(), StartActivity.class));
            SplashActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed(){
    }
}