package users;

public class User extends Thread {

	public User(String str) {
		super(str);
	}

	/*public void run() {
		for (int i = 0; i <= 20; i++) {
			System.out.println("Loop " + i + ": " + getName());
			functions.SeeAll.seeAll();
				//functions.FindBooks.findBooks();
			try {
				sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Test Finished for: " + getName());
	}*/
	
	public void run() {
		functions.FindAll.findAll();
		//functions.FindBooks.findBooks();
	}
}
