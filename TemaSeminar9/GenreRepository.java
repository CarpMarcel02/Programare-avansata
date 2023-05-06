package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
public class GenreRepository extends DataRepository<Genre, Long>{

    @Override
    protected Class<Genre> getEntityClass() {
        return Genre.class;
    }
    @Override
    protected String getFindByNameNamedQuery() {
        return "Genre.findByArtist";
    }

}