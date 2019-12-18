package sensors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import abstracts.PublisherAbstract;
import abstracts.SubscriberAbstract;

public class Lamp implements PublisherAbstract, SubscriberAbstract, MqttCallback {

	private static final String brokerUrl = "tcp://localhost:1883";
	// private static final String brokerUrl = "tcp://broker.hivemq.com:1883";
	private static int qos = 1;
	protected static String state;
	private static String clientId;
	private static String topic;
	public static ObjectOutputStream oos;
	public static ObjectInputStream ois;

	public Lamp() {
	}

	public static void main(String[] args) throws InterruptedException {

		setState("on");
		setClientId("Lampa");
		setTopic("lamp");

		new Lamp().publish(getState());

	}

	public void publish(String state) {
		MemoryPersistence persistence = new MemoryPersistence(); // to store in-flight messages

		try {
			MqttClient client = new MqttClient(brokerUrl, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true); // the broker doesn't store undelivered messages
			System.out.println("Connecting to broker: " + brokerUrl);
			client.connect(connOpts);
			System.out.println("Connected successfully!");
			System.out.println("Publishing message:" + state);
			MqttMessage message = new MqttMessage(state.getBytes());
			message.setQos(qos); // set the Quality of Sevice
			message.setRetained(true); // the broker keeps the last published message on that topic
			client.publish(topic, message);
			output(); // timer output
			System.out.println("Message published");
			
			client.disconnect(); // disconnects from the server
			client.close(); // close the client and releases all resources associated with client
		} catch (MqttException me) {
			System.out.println(me);
		}
	}

	public static void setClientId(String clientId) {
		Lamp.clientId = clientId;
	}

	public static void setTopic(String topic) {
		Lamp.topic = topic;
	}

	public static String getTopic() {
		return topic;
	}

	public static String getState() {
		return state;
	}

	public static void setState(String state) {
		Lamp.state = state;
	}

	@Override
	public void subscribe(String topic) {
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient client = new MqttClient(brokerUrl, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);

			System.out.println("Mqtt Connecting to broker: " + brokerUrl);

			client.connect(connOpts);
			System.out.println("Mqtt Connected");

			client.setCallback(this);
			client.subscribe(topic);
			System.out.println("Subscribed topic: " + topic);
			client.disconnect();
			client.close();
		} catch (MqttException me) {
			System.out.println(me);
		}
	}

	@Override
	public void connectionLost(Throwable arg0) {
		System.out.println("The connection to the server has been lost.");
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		System.out.println("Delivery of a messsage to the server has completed.");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("-------------------------------------------");
		System.out.println("| Topic:" + topic);
		System.out.println("| Message: " + message.toString());
		System.out.println("-------------------------------------------------");

		setState(message.toString());
		System.out.println("The lamp status has been changed: " + state);

	}

	// sending message 'start' to timer
	public void output() {
		try {
			Socket socket = new Socket("127.0.0.1", 5000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("start");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
