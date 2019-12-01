package com.example.mqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class ActivityPublish extends AppCompatActivity {

    private Button bPublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        String clientId = MqttClient.generateClientId();
        final MqttAndroidClient client =
                new MqttAndroidClient(ActivityPublish.this, "tcp://broker.hivemq.com:1883",
                        clientId);

        bPublish = (Button) findViewById(R.id.bPublish);
        bPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = "lampa";
                String payload = "on";
                byte[] encodedPayload = new byte[0];
                try {
                    encodedPayload = payload.getBytes("UTF-8");
                    MqttMessage message = new MqttMessage(encodedPayload);
                    client.publish(topic, message);
                } catch (UnsupportedEncodingException | MqttException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}