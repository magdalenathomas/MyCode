package repository;

import repository.model.CompanyEntity;
import repository.model.CompanyItem;

import javax.persistence.Query;
import java.util.Collection;

public class CompanyRepository extends AbstractRepository {

    public void save(CompanyItem item) throws Exception {
        CompanyEntity entity = new CompanyEntity();
        entity.setId_company(item.getId_company());
        entity.setCity(item.getCity());
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public Collection<CompanyEntity> findAll() {
        Query query = em.createQuery("Select c from CompanyEntity c");
        return (Collection<CompanyEntity>) query.getResultList();
    }

    public void updateCity(String oldCity, String newCity) {
        em.getTransaction().begin();
        Query q = em.createQuery("UPDATE CompanyEntity d set d.city=:newCity WHERE d.city=:oldCity");
        q.setParameter("oldCity", oldCity);
        q.setParameter("newCity", newCity);
        q.executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteAll() {
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM CompanyEntity b where 1=1");
        q.executeUpdate();
        em.getTransaction().commit();
    }
}
