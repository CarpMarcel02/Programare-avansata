package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static jdk.jfr.events.FileForceEvent.commit;
import static org.example.Database.rollback;

public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {

    protected abstract Class<T> getEntityClass();
    protected abstract String getFindByNameNamedQuery(); // Add this method
    /**
     * creeaza intial o instanta a lui EntityManager, semnaleaza inceputul unei tranzactii in baza de date, salveaza obiectul prin entityManager.persist
     * verific salvarea in baza de date prin flush si finalizeaza comenzile prin commit si inchid prin close EntityManager-ul
     * @param obiect
     * @return
     */
    public T create(T obiect) {
        EntityManager entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
        entityManager.getTransaction().begin();

        if (obiect instanceof Album) {
            Album album = (Album) obiect;
            List<Genre> managedGenres = new ArrayList<>();

            for (Genre genre : album.getGenres()) {
                managedGenres.add(entityManager.merge(genre));
            }

            album.setGenres(managedGenres);
        }
        entityManager.persist(obiect);
        entityManager.flush(); // Flush to synchronize the state with the database
        entityManager.getTransaction().commit();
        entityManager.close();
        return obiect;
    }
    /**
     * creeaza o instanta a lui EnttityManager si cauta prin entityManager.find dupa id-ul necesar obiectului pe care il cauta.
     * @param id
     * @return
     */
    public T findById(Long id) {
        {
            if (id == null) {
                throw new IllegalArgumentException("Id cannot be null");
            }
            EntityManager entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
            T obiect = entityManager.find(getEntityClass(), id);
            entityManager.close();
            return obiect;
        }
    }
    /**
     * functia creeaza o instanta pentru a efectua operatii pe baza de date. Creeaza un Query care il ajuta sa caute dupa tipul obiectul si dupa
     * se apeleaza cautarea prin getResultList
     * @param name
     * @return
     */
    public List<T> findByName(String name) {
        EntityManager entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
        TypedQuery<T> query = entityManager.createNamedQuery(getFindByNameNamedQuery(),getEntityClass());
        query.setParameter(1, name);
        List<T> obiect = query.getResultList();
        entityManager.close();
        return obiect;
    }


}
