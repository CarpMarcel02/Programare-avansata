package org.example;

import javax.persistence.EntityManager;

import java.io.Serializable;

import static jdk.jfr.events.FileForceEvent.commit;
import static org.example.Database.rollback;

public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {

    protected abstract Class<Album> getEntityClass();



}
