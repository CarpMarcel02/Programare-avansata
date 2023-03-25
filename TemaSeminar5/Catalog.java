package org.Seminar5;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;
import java.io.Serializable;



public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();

    public Catalog() {
        // empty constructor
    }
    public void add(Document doc) {
        docs.add(doc);

    }
    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }

    public Document findById(String id) {
        for (var doc : docs) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Catalog(String name) {
        this.name = name;
    }

}
