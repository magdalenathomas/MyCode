package com.example.mqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class ActivitySubscribe extends AppCompatActivity {

    private Button bSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        String clientId = MqttClient.generateClientId();
        final MqttAndroidClient client =
                new MqttAndroidClient(ActivitySubscribe.this, "tcp://broker.hivemq.com:1883",
                        clientId);
        bSubscribe = (Button) findViewById(R.id.bSubscribe);
        bSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = "lampa";
                int qos = 1;
                try {
                    IMqttToken subToken = client.subscribe(topic, qos);
                    subToken.setActionCallback(new IMqttActionListener() {
                        @Override
                        public void onSuccess(IMqttToken asyncActionToken) {
                            Toast.makeText(ActivitySubscribe.this, "You can subscribe", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(IMqttToken asyncActionToken,
                                              Throwable exception) {
                            Toast.makeText(ActivitySubscribe.this, "You can not subscribe", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        client.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                Toast.makeText(ActivitySubscribe.this, new String(message.getPayload()), Toast.LENGTH_SHORT);
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });

    }
}
