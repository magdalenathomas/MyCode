package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import abstracts.PublisherAbstract;

public class TestPub extends PublisherAbstract {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter your id: ");
		setClientId(reader.readLine());
		
		System.out.println("Enter the topic: ");
		setTopic(reader.readLine());
		
		System.out.println("Enter the message: ");
		String state = reader.readLine();

		new TestPub().publish(state);
	}

}
