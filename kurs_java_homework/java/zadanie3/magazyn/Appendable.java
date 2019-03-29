package zadanie3.magazyn;

	/**
	 * Interfejs do zwiększania kolekcji
	 * 
	 * @author pawel.apanasewicz@codeme.pl
	 *
	 */
	public interface Appendable {

	    /**
	     * Dodanie kolejnego elementu do kolekcji
	     * 
	     * @param item Nowy element kolekcji
	     * 
	     * @return Powiększana kolekcja
	     */
	    public Appendable append(Object item);

	    /**
	     * Dodanie elementu na podaną pozycję, jeśli na danej pozycji jest już element zostanie zamieniony
	     * 
	     * @param item Wrzucany element
	     * @param index Pozycja elementu
	     * 
	     * @return Powiększana kolekcja
	     */
	    public Appendable append(Object item, int index);

}

