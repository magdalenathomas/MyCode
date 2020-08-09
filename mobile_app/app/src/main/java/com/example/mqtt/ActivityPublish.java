package com.example.mqtt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.UnsupportedEncodingException;

public class ActivityPublish extends AppCompatActivity {

    private Button bPublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        String clientId = MqttClient.generateClientId();
        final IMqttActionListener callback = null;
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        final MqttAndroidClient client =
                new MqttAndroidClient(ActivityPublish.this,  "tcp://localhost:1883",
                        clientId, memoryPersistence);
        final IMqttToken connect;
        try {
            client.connect();
            connect = client.connect();
            connect.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(ActivityPublish.this, "Ccnnected", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(ActivityPublish.this, "Not connected", Toast.LENGTH_SHORT).show();
                }
            });
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
                        message.setQos(2);
                        message.setRetained(true);


                        IMqttToken token =  client.publish(topic, message, this , callback) ;
                        token.setActionCallback(new IMqttActionListener() {
                            @Override
                            public void onSuccess(IMqttToken asyncActionToken) {
                                Toast.makeText(ActivityPublish.this, "published", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                                Toast.makeText(ActivityPublish.this, "not published", Toast.LENGTH_SHORT).show();
                            }
                        });


                    } catch (UnsupportedEncodingException | MqttException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }


    }
}