package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestJPA {
    public static void main(String[] args) {

        AlbumRepository albumRepository = new AlbumRepository();

        Album album = new Album();
        album.setReleaseYear(1967);
        album.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        album.setArtist("The Beatles");
        album.setGenre("Rock");
        albumRepository.create(album);

        Album foundAlbum = albumRepository.findById(1L);
        System.out.println("Found Album: " + foundAlbum);

        List<Album> albumsByArtist = albumRepository.findByArtist("The Beatles");
        System.out.println("Albums by The Beatles: " + albumsByArtist);
    }
}