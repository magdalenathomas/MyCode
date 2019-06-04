package repository;

import repository.model.CompanyEntity;
import repository.model.CompanyItem;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class CompanyRepository extends AbstractRepository {

    public void save(CompanyItem item) throws Exception {
        CompanyEntity entity = new CompanyEntity();
       // entity.setId_company(item.getId_company());
        entity.setCity(item.getCity());
        em.persist(entity);
    }
    public void save(CompanyEntity item) throws Exception {
        em.persist(item);

    }

    public Collection<CompanyEntity> findAll() {
        Query query = em.createQuery("Select c from CompanyEntity c");
        return (Collection<CompanyEntity>) query.getResultList();
    }

    public void deleteAll() {
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM CompanyEntity b where 1=1");
        q.executeUpdate();
        em.getTransaction().commit();
    }

    public void save(List<CompanyItem> companies) throws Exception {
        em.getTransaction().begin();
        for (CompanyItem company : companies) {
            save(company);
        }
        em.getTransaction().commit();
    }

    public Collection<CompanyEntity> findAllByCityName(String oldName) {
        Query query = em.createQuery("Select c from CompanyEntity c WHERE c.city=:oldName");
        query.setParameter("oldName", oldName);
        return (Collection<CompanyEntity>) query.getResultList();

    }

}
