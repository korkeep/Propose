package com.korkeep.s_talk.Fingerprint.callback;

import com.korkeep.s_talk.Fingerprint.utils.FingerprintToken;

public interface FingerprintSecureCallback {
    void onAuthenticationSucceeded();
    void onAuthenticationFailed();
    void onNewFingerprintEnrolled(FingerprintToken token);
    void onAuthenticationError(int errorCode, String error);
}
