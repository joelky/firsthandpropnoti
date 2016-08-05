/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fcm.firsthandpptynoti.fcm;

        import android.app.IntentService;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.preference.PreferenceManager;
        import android.support.v4.content.LocalBroadcastManager;
        import android.util.Log;

        import com.fcm.firsthandpptynoti.R;
        import com.google.android.gms.gcm.GcmPubSub;
        import com.google.android.gms.gcm.GoogleCloudMessaging;
        import com.google.android.gms.iid.InstanceID;
        import com.google.firebase.iid.FirebaseInstanceId;
        import com.google.firebase.messaging.FirebaseMessaging;

        import java.io.IOException;

public class RegistrationIntentService extends IntentService {

    private static final String TAG = "RegIntentService";
    public static final String SENT_TOKEN_TO_SERVER = "sentTokenToServer";
    public static final String FCM_TOKEN = "FCMToken";
    private static final String[] TOPICS = {"global"};

    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Make a call to Instance API
        FirebaseInstanceId instanceID = FirebaseInstanceId.getInstance();
        // TODO: senderId never used
//        String senderId = getResources().getString(R.string.gcm_defaultSenderId);
        try {
            // [START register_for_gcm]
            // Initially this call goes out to the network to retrieve the token, subsequent calls
            // are local.
            // R.string.gcm_defaultSenderId (the Sender ID) is typically derived from google-services.json.
            // See https://developers.google.com/cloud-messaging/android/start for details on this file.
            // [START get_token]
            // request token that will be used by the server to send push notifications
            String token = instanceID.getToken();
            Log.d(TAG, "FCM Registration Token: " + token);
            // save token
            sharedPreferences.edit().putString(FCM_TOKEN, token).apply();
            // pass along this data
            // TODO: Implement this method to send any registration to your app's servers.
            sendRegistrationToServer(token);

            /*
             * Subscribe to topic channels
             */
            subscribeTopics(token);
        } catch (Exception e) {  //Changed from IOException
            Log.d(TAG, "Failed to complete token refresh", e);
            // TODO: remove printStackTrace()?
//            e.printStackTrace();
            sharedPreferences.edit().putBoolean(SENT_TOKEN_TO_SERVER, false).apply();
        }

        /*
        * FCM also supports opt-in topic-based subscriptions for clients, which does not require passing along the device token to your server.
        */
        //FirebaseMessaging.getInstance().subscribeToTopic("/topics/" + "dogs");

    }

    /**
     * Persist registration to third-party servers.
     *
     * Modify this method to associate the user's GCM registration token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // Add custom implementation, as needed.
        // send network request
        // if registration sent was successful, store a boolean that indicates whether the generated token has been sent to server
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putBoolean(SENT_TOKEN_TO_SERVER, true).apply();
    }

    /**
     * Subscribe to any GCM topics of interest, as defined by the TOPICS constant.
     *
     * @param token GCM token
     * @throws IOException if unable to reach the GCM PubSub service
     */
    // [START subscribe_topics]
    private void subscribeTopics(String token) throws IOException {
        for (String topic : TOPICS) {
            // Non-blocking methods. No need to use AsyncTask or background thread.
            FirebaseMessaging.getInstance().subscribeToTopic("mytopic");
//            FirebaseMessaging.getInstance().unsubscribeToTopic("mytopic");
        }
    }
    // [END subscribe_topics]
}