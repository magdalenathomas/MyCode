package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import abstracts.PublisherAbstract;
import abstracts.SubscriberAbstract;
import abstracts.Watch;

public class Inmate implements SubscriberAbstract, MqttCallback, PublisherAbstract {

	private static final String brokerUrl = "tcp://localhost:1883";
	protected static String clientId;
	protected static String topic;
	private static int qos = 0;
	//private static long start;
	//private static long stop;
	//private static long odds;
	String nState;
	//Random generator = new Random();
	
	public Inmate() {
		topic = "aavvv";
		clientId = "m";
	}

	public static void main(String[] args) throws IOException {

		/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter your id: ");
		setClientId(reader.readLine());

		System.out.print("Enter the topic: ");
		setTopic(reader.readLine());*/
		
		new Inmate().subscribe(topic);

	}

	public void subscribe(String topic) {
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient client = new MqttClient(brokerUrl, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);

			System.out.println("Connecting to broker: " + brokerUrl);

			client.connect(connOpts);
			System.out.println("Mqtt Connected");

			client.setCallback(this);
			client.subscribe(topic);
			//start = System.currentTimeMillis();
			//System.out.println("clock is active");
			
			System.out.println("Subscribed topic: " + topic);

		} catch (MqttException me) {
			System.out.println(me);
		}
	}

	public static String getTopic() {
		return topic;
	}

	public static void setTopic(String topic) {
		Inmate.topic = topic;
	}

	public static void setClientId(String clientId) {
		Inmate.clientId = clientId;
	}

	public static String getClientId() {
		return clientId;
	}

	public String getnState() {
		return nState;
	}

	public void setnState(String nState) {
		this.nState = nState;
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws IOException {
		
		Watch.stop();
		Watch.time();
		//stop = (long) (System.currentTimeMillis()/1000.0);
		//System.out.println("clock is stopped " + stop);
		//odds = stop - start;
		//System.out.println("Czas odpowiedzi wynosi: " + odds);
		System.out.println("| Topic:" + topic);
		System.out.println("| Message: " + message.toString());
		System.out.println("-------------------------------------------------");

		/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Would you like to change the state? Write yes or no");
		if (reader.readLine().equals("yes")) {
			changeState(message);
		}*/ 		
		
	}

	public void changeState(MqttMessage message) {
		System.out.println("Rozpoczeto proces zmian...");

		if (message.toString().equals("on")) {
			setnState("off");
		} else {
			setnState("on");
		}
		
		
		new Inmate().publish(getnState());
	}

	@Override
	public void publish(String state) {
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient sampleClient = new MqttClient(brokerUrl, getClientId(), persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + brokerUrl);
			sampleClient.connect(connOpts);
			System.out.println("Connected to broker");
			System.out.println("Publishing message:" + state);
			MqttMessage message = new MqttMessage(state.getBytes());
			message.setQos(qos);
			message.setRetained(true);
			sampleClient.publish(getTopic(), message);
			System.out.println("Message published");
			//sampleClient.disconnect();
			//sampleClient.close();
			//System.exit(0);
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		}
	}

	@Override
	public void connectionLost(Throwable arg0) {
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		System.out.println("Delivery Complete");
	}

}