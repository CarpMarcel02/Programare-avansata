package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
public class AlbumRepository extends DataRepository<Album, Long>{
    //private EntityManager em; //create it somehow

    @Override
    protected Class<Album> getEntityClass() {
        return Album.class;
    }

    /**
     * functia creeaza o instanta pentru a efectua operatii pe baza de date. Creeaza un Query care il ajuta sa caute dupa artist si dupa
     * se apeleaza cautarea prin getResultList
     * @param artist
     * @return
     */
    public List<Album> findByArtist(String artist) {
        EntityManager entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
        TypedQuery<Album> query = entityManager.createNamedQuery("Album.findByArtist", Album.class);
        query.setParameter(1, artist);
        List<Album> albums = query.getResultList();
        entityManager.close();
        return albums;
    }

    /**
     * creeaza o instanta a lui EnttityManager si cauta prin entityManager.find dupa id-ul necesar albumul pe care il cauta.
     * @param id
     * @return
     */
    public Album findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        EntityManager entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
        Album album = entityManager.find(getEntityClass(), id);
        entityManager.close();
        return album;
    }

    /**
     * creeaza intial o instanta a lui EntityManager, semnaleaza inceputul unei tranzactii in baza de date, salveaza albumul prin entityManager.persist
     * verific salvarea in baza de date prin flush si finalizeaza comenzile prin commit si inchid prin close EntityManager-ul
     * @param album
     * @return
     */
    public Album create(Album album) {
        EntityManager entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.flush(); // Flush to synchronize the state with the database
        entityManager.getTransaction().commit();
        entityManager.close();
        return album;
    }

}