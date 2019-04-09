package repository;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import repository.model.AuthorsEntity;
import repository.model.AuthorsItem;
import repository.model.BooksEntity;
import repository.model.BooksItem;
import repository.model.CompanyEntity;
import repository.model.CompanyItem;
import repository.model.OrdersEntity;
import repository.model.OrdersItem;
import repository.model.UsersEntity;
import repository.model.UsersItem;

public class JPA {
		
		private EntityManager em;

		public JPA() {
			em = Persistence.createEntityManagerFactory("magda").createEntityManager();
		}

		public void close() throws IOException {
			em.close();
		}


		public void save(AuthorsItem item) throws Exception {
			AuthorsEntity entity = new AuthorsEntity();
			entity.setAuthor_name(item.getAuthor_name());
			entity.setAuthor_surname(item.getAuthor_surname());
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}
		
		public void save(CompanyItem item) throws Exception {
			CompanyEntity entity = new CompanyEntity();
			entity.setCity(item.getCity());
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}
		
		public void save(UsersItem item) throws Exception {
			UsersEntity entity = new UsersEntity();
			entity.setUser_name(item.getUser_name());
			entity.setUser_surname(item.getUser_surname());
			entity.setUser_mejl(item.getUser_mejl());
			entity.setUser_telephone(item.getUser_telephone());
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}
		
		public void save(BooksItem item) throws Exception {
			BooksEntity entity = new BooksEntity();
			entity.setTitle(item.getTitle());
			entity.setYear(item.getYear());
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}

		public void save(OrdersItem item) throws Exception {
			OrdersEntity entity = new OrdersEntity();
			entity.setDate_hire(item.getDate_hire());
			entity.setDate_return(item.getDate_return());
			entity.setDebt(item.isDebt());
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}
}
