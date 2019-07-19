package homework3;

public class GenericCollection<K, V> {

	@SuppressWarnings("unchecked")
	public K[] tab_key = (K[]) new Object[7];
	@SuppressWarnings("unchecked")
	public V[] tab_value = (V[]) new Object[7];
	
	
	public static void main(String[] args) {
		GenericCollection<String, String> tab1 = new GenericCollection<String, String>();
		tab1.adding("imie", "magda");
		tab1.wypisz();
		GenericCollection<Integer, String> tab2 = new GenericCollection<Integer, String>();
		tab2.adding(1, "ksiaza");
		tab2.adding(2, "gazeta");
		tab2.wypisz();
	}
	
	public GenericCollection<K,V> adding(K key, V value) {
		this.adding("key", value);
		this.adding("value", value);
		
		return this;
	}
		
	@SuppressWarnings("unchecked")
	public void adding(String key, Object value) {
		for (int x=0; x<tab_key.length; x++) {
			if (tab_key[x] == null) {
				tab_key[x] = (K)key;
				break;
			} else {
				System.out.println("Tablica skończona");
			}
		}
		for (int x=0; x<tab_value.length; x++) {
			if (tab_value[x] == null) {
				tab_value[x] = (V)value;
				break;
			} else {
				System.out.println("Tablica skończona");
			}
		}
	}
	
	public void wypisz() {
		System.out.println("Klucze:");
		for (int x=0; x<tab_key.length; x++) {
			System.out.println(tab_key[x]);
		}
		System.out.println("Wartości:");
		for (int x=0; x<tab_value.length; x++) {
			System.out.println(tab_value[x]);
		}
	}
}
