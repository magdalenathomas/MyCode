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

public class Lamp implements PublisherAbstract, SubscriberAbstract, MqttCallback, timer.Client {

	// private static final String brokerUrl = "tcp://localhost:1883";
	private static final String brokerUrl = "tcp://broker.hivemq.com:1883";
	private static int qos = 0;
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
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient client = new MqttClient(brokerUrl, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + brokerUrl);
			client.connect(connOpts);
			System.out.println("Connected to broker");
			System.out.println("Publishing message:" + state);
			MqttMessage message = new MqttMessage(state.getBytes());
			message.setQos(qos);
			message.setRetained(true);
			client.publish(topic, message);

			// TIMER
			output();

			System.out.println("Message published");
			Thread.sleep(1000);
			client.disconnect();
			client.close();
			// System.exit(0);
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
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
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		System.out.println("Delivery Complete");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("-------------------------------------------");
		System.out.println("| Topic:" + topic);
		System.out.println("| Message: " + message.toString());
		System.out.println("-------------------------------------------------");

		setState(message.toString());
		System.out.println("Zmieniono stan lampki na " + state);

	}

	@Override
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


	@Override
	public void output(int number) {
		// TODO Auto-generated method stub

	}
}
