package com.korkeep.s_talk.Fingerprint.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class FingerprintToken {
    private final CipherHelper cipherHelper;

    public FingerprintToken(CipherHelper cipherHelper) {
        this.cipherHelper = cipherHelper;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void validate(){
        if(cipherHelper !=null) {
            cipherHelper.generateNewKey();
        }
    }
}
