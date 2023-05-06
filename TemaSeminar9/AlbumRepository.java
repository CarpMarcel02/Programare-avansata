package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
public class AlbumRepository extends DataRepository<Album, Long>{

    @Override
    protected Class<Album> getEntityClass() {
        return Album.class;
    }
    @Override
    protected String getFindByNameNamedQuery() {
        return "Album.findByArtist";
    }

}