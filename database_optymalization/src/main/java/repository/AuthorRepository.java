package repository;

import repository.model.AuthorsEntity;
import repository.model.AuthorsItem;

import javax.persistence.Query;
import java.util.Collection;

public class AuthorRepository extends AbstractRepository {

    public void save(AuthorsItem item) throws Exception {
        repository.model.AuthorsEntity entity = new repository.model.AuthorsEntity();
        entity.setId_authors(item.getId_authors());
        entity.setAuthor_name(item.getAuthor_name());
        entity.setAuthor_surname(item.getAuthor_surname());
        save(entity);
    }

    public void save(AuthorsEntity entity) throws Exception {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public Collection<AuthorsEntity> findAll() {
        Query query = em.createQuery("Select a from " + repository.model.AuthorsEntity.class.getSimpleName() + " a");
        return (Collection<repository.model.AuthorsEntity>) query.getResultList();
    }

    public void deleteAll() {
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM AuthorsEntity b where 1=1");
        q.executeUpdate();
        em.getTransaction().commit();
    }
}
