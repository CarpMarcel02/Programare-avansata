package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
public class ArtistRepository extends DataRepository<Artist, Long>{

    @Override
    protected Class<Artist> getEntityClass() {
        return Artist.class;
    }
    @Override
    protected String getFindByNameNamedQuery() {
        return "Artist.findByArtist";
    }

}