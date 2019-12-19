package clients;

import java.io.IOException;
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

public class Inmate implements SubscriberAbstract, MqttCallback, PublisherAbstract {

	private static final String brokerUrl = "tcp://localhost:1883";
	protected static String clientId;
	protected static String topic;
	private static int qos = 2;
	// String nState;
	public static ObjectOutputStream oos;

	public Inmate(int number) {
		setTopic("lamp");
		setClientId(MqttClient.generateClientId()); // randomly generated client identifier
	}

	public void subscribe(String topic) {
		MemoryPersistence persistence = new MemoryPersistence(); // to store in-flight messages

		try {
			MqttClient client = new MqttClient(brokerUrl, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true); // the broker doesn't store undelivered messages
			System.out.println("Connecting to broker: " + brokerUrl);
			client.connect(connOpts);
			System.out.println("Connected successfully!");
			client.setCallback(this); // create a listener for events - messageArrived, lost connection, delivery
										// completed
			client.subscribe(topic);
			System.out.println("Subscribed topic: " + topic);

			client.disconnect(); // disconnects from the server
			client.close(); // close the client and releases all resources associated with client

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

	/*
	 * public String getnState() { return nState; }
	 */

	/*
	 * public void setnState(String nState) { this.nState = nState; }
	 */

	@Override
	public void connectionLost(Throwable arg0) {
		System.out.println("The connection to the server has been lost.");
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		System.out.println("Delivery of a messsage to the server has completed.");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws IOException {

		System.out.println("| Topic:" + topic);
		System.out.println("| Message: " + message.toString());
		System.out.println("-------------------------------------------------");

		//only used when QoS=1 or Qos=2
		try {
			Socket socket = new Socket("127.0.0.1", 5000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("hi server!");
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 * System.out.print("Would you like to change the state? Write yes or no"); if
		 * (reader.readLine().equals("yes")) { changeState(message); }
		 */

	}

	/*
	 * public void changeState(MqttMessage message) {
	 * System.out.println("Rozpoczeto proces zmian...");
	 * 
	 * if (message.toString().equals("on")) { setnState("off"); } else {
	 * setnState("on"); }
	 * 
	 * 
	 * //new Inmate().publish(getnState()); }
	 */

	@Override
	public void publish(String state) {
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient client = new MqttClient(brokerUrl, getClientId(), persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + brokerUrl);
			client.connect(connOpts);
			System.out.println("Connected to broker");
			System.out.println("Publishing message:" + state);
			MqttMessage message = new MqttMessage(state.getBytes());
			message.setQos(qos);
			message.setRetained(true);
			client.publish(getTopic(), message);
			System.out.println("Message published");
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
		}
	}

}
