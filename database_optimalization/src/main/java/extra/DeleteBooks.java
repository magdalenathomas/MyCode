package extra;

import repository.JPA;

public class DeleteBooks {

	public static void deleteBook() {
		JPA repo = null;
		repo = new JPA();
		repo.delete(1970);
		
	}
}
