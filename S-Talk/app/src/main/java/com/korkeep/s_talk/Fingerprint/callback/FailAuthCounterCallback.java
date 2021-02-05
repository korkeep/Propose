package com.korkeep.s_talk.Fingerprint.callback;

import com.korkeep.s_talk.Fingerprint.view.Fingerprint;

public interface FailAuthCounterCallback {
    void onTryLimitReached(Fingerprint fingerprint);
}
