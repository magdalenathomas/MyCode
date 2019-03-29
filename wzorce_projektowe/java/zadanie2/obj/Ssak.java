package zadanie2.obj;

public abstract class Ssak {
	
	public int mass;
	public int age;
	public String sex;
	
	public Ssak() {
		System.out.println("Piję mleko matki");
	}

	public abstract void weight(int mass); 
	
	public void whatSex(String sex) {
		System.out.println("Jestem " + sex);
	}
	
	public void age(int age) {
		System.out.println("Mam " + age + "lata");
	}
	
}
