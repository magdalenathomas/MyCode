package repository;

import repository.model.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class JPA {

	private static EntityManager em;

	public JPA() {
		em = Persistence.createEntityManagerFactory("magda").createEntityManager();
	}

	public void close() throws IOException {
		em.close();
	}



	public Collection<UsersEntity> findAllUsers() {
		Query query = em.createQuery("Select a from " + UsersEntity.class.getSimpleName() + " a");
		return (Collection<UsersEntity>) query.getResultList();
	}

	public void save(UsersItem item) throws Exception {
		UsersEntity entity = new UsersEntity();
		//entity.setId_users(item.getId_users());
		entity.setUser_name(item.getUser_name());
		entity.setUser_surname(item.getUser_surname());
		entity.setUser_mejl(item.getUser_mejl());
		entity.setUser_telephone(item.getUser_telephone());

		em.persist(entity);
	}

	public void save(OrdersItem item) throws Exception {
		OrdersEntity entity = new OrdersEntity();
		//entity.setId_order(item.getId_order());
		entity.setDate_hire(item.getDate_hire());
		entity.setDate_return(item.getDate_return());
		entity.setDebt(item.isDebt());
		entity.setBooksEntity(item.getBooksEntity());
		entity.setUsersEntity(item.getUsersEntity());
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}
	
	public static BooksItem[] getAll()  {
		TypedQuery<BooksEntity> q = em.createQuery("SELECT d FROM BooksEntity d", BooksEntity.class);
		List<BooksEntity> res = q.getResultList();
		BooksItem[] all = new BooksItem[res.size()];
		for (int i = 0; i < res.size(); i++) {
			all[i] = res.get(i).getBooksItem();
		}
		return all;
	}


	public void deleteAllBooks() {
		em.getTransaction().begin();
		Query q = em.createQuery("DELETE FROM BooksEntity b where 1=1");
		q.executeUpdate();
		em.getTransaction().commit();
	}
	public static BooksItem[] findAll(int id_company)  {
		TypedQuery<BooksEntity> q = em.createQuery("SELECT d FROM BooksEntity d WHERE d.companyEntity=:id_company", BooksEntity.class);
		List<BooksEntity> res = q.getResultList();
		BooksItem[] all = new BooksItem[res.size()];
		for (int i = 0; i < res.size(); i++) {
			all[i] = res.get(i).getBooksItem();
		}
		return all;
	}
	
	public void delete(int year) {
		em.getTransaction().begin();
		TypedQuery<BooksEntity> q = em.createQuery("SELECT e FROM BooksEntity e WHERE e.year =: year", BooksEntity.class);	   
		q.setParameter("year", year);
		List<BooksEntity> res = q.getResultList();
		em.remove(res);
		System.out.println("Usunięto pozycje z biblioteki.");
		em.getTransaction().commit();
	}
	
	public static BooksItem[] find()  {
		TypedQuery<BooksEntity> q = em.createQuery("SELECT d FROM BooksEntity d WHERE d.year=:year", BooksEntity.class);
		List<BooksEntity> res = q.getResultList();
		BooksItem[] all = new BooksItem[res.size()];
		for (int i = 0; i < res.size(); i++) {
			all[i] = res.get(i).getBooksItem();
		}
		return all;
	}

	public void deleteAllOrders() {
		em.getTransaction().begin();
		Query q = em.createQuery("DELETE FROM OrdersEntity b where 1=1");
		q.executeUpdate();
		em.getTransaction().commit();
	}

	public void deleteAllUsers() {
		em.getTransaction().begin();
		Query q = em.createQuery("DELETE FROM UsersEntity b where 1=1");
		q.executeUpdate();
		em.getTransaction().commit();

	}

	public void save(List<UsersItem> users) throws Exception {
		em.getTransaction().begin();
		for (UsersItem user : users) {
			save(user);
		}
		em.getTransaction().commit();
	}
}
