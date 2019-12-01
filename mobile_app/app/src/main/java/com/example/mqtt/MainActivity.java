package com.example.mqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttClient;

public class MainActivity extends AppCompatActivity {

    private ImageView imageLamp;
    private ImageView imageHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLamp = findViewById(R.id.imageLamp);
        imageLamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPublish();
            }
        });

        imageHome = findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySubscribe();
            }
        });
    }

    public void openActivityPublish(){
        Intent intent =  new Intent(this, ActivityConnectPub.class);
        startActivity(intent);
    }

    public void openActivitySubscribe() {
        Intent intent = new Intent(this, ActivityConnectSub.class);
        startActivity(intent);
    }
}
