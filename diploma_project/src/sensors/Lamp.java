package sensors;

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
	private static int qos = 0;
	protected static String state;
	private static String clientId;
	private static String topic;
	
	public static void main(String[] args) throws InterruptedException {
		
		setState("on");
		setClientId("Lampa");
		setTopic("lampa");
		
		new Lamp().publish(getState());
		Thread.sleep(1000);
		new Lamp().subscribe(getTopic());

	}

	public void publish(String state) {
		MemoryPersistence persistence = new MemoryPersistence();
		
		try {
			MqttClient sampleClient = new MqttClient(brokerUrl, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + brokerUrl);
			sampleClient.connect(connOpts);
			System.out.println("Connected to broker");
			System.out.println("Publishing message:" + state);
			MqttMessage message = new MqttMessage(state.getBytes());
			message.setQos(qos);
			sampleClient.publish(topic, message);
			System.out.println("Message published");
			sampleClient.disconnect();
			sampleClient.close();
			System.exit(0);
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
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

			System.out.println("Subscribed");
			System.out.println("Listening");

		} catch (MqttException me) {
			System.out.println(me);
		}
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("| Topic:" + topic);
		System.out.println("| Message: " + message.toString());
		System.out.println("-------------------------------------------------");
		
	}
	
}
