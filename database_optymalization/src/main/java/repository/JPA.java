package repository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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

	private static EntityManager em;

	public JPA() {
		em = Persistence.createEntityManagerFactory("magda").createEntityManager();
	}

	public void close() throws IOException {
		em.close();
	}

	public void save(AuthorsItem item) throws Exception {
		AuthorsEntity entity = new AuthorsEntity();
		entity.setId_authors(item.getId_authors());
		entity.setAuthor_name(item.getAuthor_name());
		entity.setAuthor_surname(item.getAuthor_surname());
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public void save(CompanyItem item) throws Exception {
		CompanyEntity entity = new CompanyEntity();
		entity.setId_company(item.getId_company());
		entity.setCity(item.getCity());
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public Collection<CompanyEntity> findAllCompanies() {
		Query query = em.createQuery("Select c from " + CompanyEntity.class.getSimpleName() + " c");
		return (Collection<CompanyEntity>) query.getResultList();
	}

	public Collection<AuthorsEntity> findAllAuthors() {
		Query query = em.createQuery("Select a from " + AuthorsEntity.class.getSimpleName() + " a");
		return (Collection<AuthorsEntity>) query.getResultList();
	}

	public Collection<BooksEntity> findAllBooks() {
		Query query = em.createQuery("Select a from " + BooksEntity.class.getSimpleName() + " a");
		return (Collection<BooksEntity>) query.getResultList();
	}

	public Collection<UsersEntity> findAllUsers() {
		Query query = em.createQuery("Select a from " + UsersEntity.class.getSimpleName() + " a");
		return (Collection<UsersEntity>) query.getResultList();
	}

	public void save(UsersItem item) throws Exception {
		UsersEntity entity = new UsersEntity();
		entity.setId_users(item.getId_users());
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
		entity.setId_books(item.getId_books());
		entity.setTitle(item.getTitle());
		entity.setYear(item.getYear());
		entity.setCompanyEntity(item.getCompanyEntity());
		entity.setAuthorsEntity(item.getAuthorsEntitySet());
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	public void save(OrdersItem item) throws Exception {
		OrdersEntity entity = new OrdersEntity();
		entity.setId_order(item.getId_order());
		entity.setDate_hire(item.getDate_hire());
		entity.setDate_return(item.getDate_return());
		entity.setDebt(item.isDebt());
		entity.setBooksEntity(item.getBooksEntity());
		entity.setUsersEntity(item.getUsersEntity());
		em.getTransaction().begin();
		em.persist(entity);
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
	
	public void change(String city) {
		TypedQuery<CompanyEntity> q = em.createQuery("SELECT d FROM CompanyEntity d WHERE d.city=:city", CompanyEntity.class);
		q.setParameter("city", city);
		CompanyEntity entity = q.getSingleResult();
		entity.setCity("Manchester");
		em.getTransaction().begin();
		em.persist(entity);
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
}
