package com.korkeep.s_talk;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.korkeep.s_talk.Fingerprint.callback.FingerprintCallback;
import com.korkeep.s_talk.Fingerprint.view.Fingerprint;

public class SplashActivity extends AppCompatActivity implements FingerprintCallback {

    ProgressDialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        dialog = Utils.showLoader(SplashActivity.this);
        Fingerprint fingerprint = findViewById(R.id.Fingerprint);
        fingerprint.callback(SplashActivity.this).authenticate();
    }

    private class splash implements Runnable{
        public void run(){
            startActivity(new Intent(getApplication(), StartActivity.class));
            SplashActivity.this.finish();
        }
    }

    @Override
    public void onAuthenticationSucceeded() {
        // Logic when fingerprint is recognized
        if(dialog!=null){
            dialog.dismiss();
        }
        Handler handler = new Handler();
        handler.postDelayed(new splash(), 500);
    }

    @Override
    public void onAuthenticationFailed() {
        // Logic when fingerprint failed to recognize
        /*if(dialog!=null){
            dialog.dismiss();
        }*/
    }

    @Override
    public void onAuthenticationError(int errorCode, String error) {
        // Logic when an error raised while authenticating
        // See Android Doc for errorCode meaning
        if(dialog!=null){
            dialog.dismiss();
        }
    }
}