package repository;

import repository.model.BooksEntity;
import repository.model.BooksItem;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

public class BookRepository extends AbstractRepository {

    public Collection<BooksEntity> findAll() {
        Query query = em.createQuery("Select a from BooksEntity a");
        Collection<BooksEntity> resultList = query.getResultList();
        return resultList;
    }

    public void save(BooksItem item) {
        BooksEntity entity = new BooksEntity();
        entity.setTitle(item.getTitle());
        entity.setYear(item.getYear());
        entity.setCompanyEntity(item.getCompanyEntity());
        entity.setAuthorsEntity(item.getAuthorsEntitySet());
        save(entity);
    }

    public void save(BooksEntity entity) {
        em.persist(entity);
    }

    private Collection<BooksEntity> findBooksByYear(int year) {
        TypedQuery<BooksEntity> query = em.createQuery("Select a from BooksEntity a where a.year = :year", BooksEntity.class);
        query.setParameter("year", year);
        return query.getResultList();
    }


    public void deleteAll() {
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM BooksEntity b where 1=1");
        q.executeUpdate();
        em.getTransaction().commit();
    }

    public void save(List<BooksItem> books) {
        em.getTransaction().begin();
        for (BooksItem book : books) {
            save(book);
        }
        em.getTransaction().commit();
    }

    public BooksEntity findFirstBook() {
        Query query = em.createQuery("Select a from BooksEntity a", BooksEntity.class);
        return (BooksEntity) query.setMaxResults(1).getSingleResult();
    }

    public void deleteOne() {
        em.getTransaction().begin();
        BooksEntity oneBook = findFirstBook();
        em.remove(oneBook);
        em.getTransaction().commit();
    }


    public void deleteByYear(int year, int delay) {
        em.getTransaction().begin();
        Collection<BooksEntity> booksByYear = findBooksByYear(year);
        System.out.println("usuwam " + booksByYear.size());
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (BooksEntity booksEntity : booksByYear) {

            em.remove(booksEntity);
        }
        em.getTransaction().commit();
    }



}
