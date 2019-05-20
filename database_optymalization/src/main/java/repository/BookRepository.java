package repository;

import repository.model.AuthorsEntity;
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
    public Collection<BooksEntity> findByCity(String city) {
        Query query = em.createQuery("Select a from BooksEntity a where a.companyEntity.city=:city");
        query.setParameter("city", city);
         return (Collection<BooksEntity>) query.getResultList();
    }
    public void save(BooksItem item) {
        BooksEntity entity = new BooksEntity();
        entity.setId_books(item.getId_books());
        entity.setTitle(item.getTitle());
        entity.setYear(item.getYear());
        entity.setCompanyEntity(item.getCompanyEntity());
        entity.setAuthorsEntity(item.getAuthorsEntitySet());
        save(entity);
    }

    public void save(BooksEntity entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public Collection<BooksEntity> findBooksOlderThan(int year) {
        TypedQuery<BooksEntity> query = em.createQuery("Select a from BooksEntity a where a.year < :year", BooksEntity.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public void deleteAll() {
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM BooksEntity b where 1=1");
        q.executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteBooksOlderThan(int year) {
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM BooksEntity b WHERE b.year=:year");
        q.setParameter("year", year);
        q.executeUpdate();
        em.getTransaction().commit();
    }

    public void updateAuthor(int oldId, int newId) {
        TypedQuery<AuthorsEntity> oldAuthorQuery = em.createQuery("Select a from AuthorsEntity a where a.id_authors=:oldId", AuthorsEntity.class);
        oldAuthorQuery.setParameter("oldId", oldId);
        AuthorsEntity oldAuthor = oldAuthorQuery.getSingleResult();

        TypedQuery<AuthorsEntity> newAuthorQuery = em.createQuery("Select a from AuthorsEntity a where a.id_authors=:newId", AuthorsEntity.class);
        newAuthorQuery.setParameter("newId", newId);
        AuthorsEntity newAuthor = newAuthorQuery.getSingleResult();

        TypedQuery<BooksEntity> query = em.createQuery("Select a from BooksEntity a join a.authorsEntity b where  b.id_authors=:id", BooksEntity.class);
        query.setParameter("id", oldId);
        List<BooksEntity> resultList = query.getResultList();

        for (BooksEntity booksEntity : resultList) {
            booksEntity.getAuthorsEntity().remove(oldAuthor);
            booksEntity.getAuthorsEntity().add(newAuthor);
            System.out.println("Update old: " + oldAuthor.getAuthor_name() + " new: "+newAuthor.getAuthor_name());
            save(booksEntity);
        }

    }

}
