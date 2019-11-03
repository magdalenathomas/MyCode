package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import abstracts.SubscriberAbstract;

public class Test extends SubscriberAbstract{

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter your id: ");
		setClientId(reader.readLine());

		System.out.print("Enter the topic: ");
		setTopic(reader.readLine());

		new Test().subscribe(getTopic());
		
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) {
		// TODO Auto-generated method stub
		
	}

}
