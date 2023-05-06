package org.example;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton  {
        private static EntityManagerFactory entityManagerFactory;

    private EntityManagerFactorySingleton() {
    }

    public static EntityManagerFactory getInstance() {
        if (entityManagerFactory == null) {
            synchronized(EntityManagerFactorySingleton.class){
                if(entityManagerFactory==null)
                {
                    entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");

                }
            }
        }

        return entityManagerFactory;

    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}