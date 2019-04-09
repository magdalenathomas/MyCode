package repository;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPA {
		
		private EntityManager em;

		public JPA() {
			em = Persistence.createEntityManagerFactory("magda").createEntityManager();
		}

		public void close() throws IOException {
			em.close();
		}
		/*
		public BooksItem[] getAll()  {
			TypedQuery<BookEntity> q = em.createQuery("SELECT d FROM BookEntity d", BookEntity.class);
			List<BookEntity> res = q.getResultList();
			BooksItem[] all = new BooksItem[res.size()];
			for (int i = 0; i < res.size(); i++) {
				all[i] = res.get(i).getBooksItem();
			}
			return all;
		}

		public void save(BooksItem item) throws Exception {
			BookEntity entity = new BookEntity();
			entity.setTitle(item.getTitle());
			entity.setAuthor(item.getAuthor());
			entity.setReleaseDate(item.getReleaseDate());
			entity.setQuantity(item.getQuantity());

			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}
		
		public void delete(String title) {
			em.getTransaction().begin();
			TypedQuery<BookEntity> q = em.createQuery("SELECT e FROM BookEntity e WHERE e.title = :title", BookEntity.class);	   
			q.setParameter("title", title);
			BookEntity entity = q.getSingleResult();
			em.remove(entity);
			System.out.println("Usunięto pozycje z biblioteki.");
			em.getTransaction().commit();
		}
		
		public void seeOne(String title) {
			em.getTransaction().begin();
			TypedQuery<BookEntity> q = em.createQuery("SELECT e FROM BookEntity e WHERE e.title = :title", BookEntity.class);	   
			q.setParameter("title", title);
			BookEntity entity = q.getSingleResult();
			System.out.println("Informacje na temat szukanej książki o tytule: " + entity.getTitle());
			System.out.println("Autor: " + entity.getAuthor());
			System.out.println("Data wydania: " + entity.getReleaseDate());
			System.out.println("Ilość: " + entity.getReleaseDate());
			em.getTransaction().commit();
		}
	} */

}
