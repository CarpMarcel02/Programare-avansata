package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "genres")
@NamedQueries({@NamedQuery(name = "Genre.findAll", query = "select e from Genre e order by e.name"),})
public class Genre extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "genres")
    private List<Album> albums;

    @Column(name = "name")
    private String name;

    // Default constructor
    public Genre() {
    }

    // Your other constructors
    public Genre(Long id, List<Album> albums, String name) {
        this.id = id;
        this.albums = albums;
        this.name = name;
    }

    public Genre(String name) {
        this.name = name;
    }

    // Your existing getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}