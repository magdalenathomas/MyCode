package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractRepository {
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("magda");
    protected EntityManager em;

    public AbstractRepository() {
        em = emf.createEntityManager();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                if(em.isOpen())
                em.close();
            }
        });
    }
}
