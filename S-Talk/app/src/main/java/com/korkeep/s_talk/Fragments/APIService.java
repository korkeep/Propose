package com.korkeep.s_talk.Fragments;

import com.korkeep.s_talk.Notifications.MyResponse;
import com.korkeep.s_talk.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAufaRe2U:APA91bEFfLbQGB-9vzxPyKDlxnRmTzzXG-nqpDHkHXmDXTk4vKiVZThVUDNMvHKM-J_oHAMSRLd3UtRJze0Z5MB2rD2u_65Ggb2KYKCitDez5blMqy5aQW9ekZVYmi5WYA7LLrvqqYcq"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
