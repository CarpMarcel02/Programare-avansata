package org.example;

import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TestJPA {
    public static void main(String[] args) {
        // Repositories
        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();
        GenreRepository genreRepository = new GenreRepository();

        // JavaFaker instance
        Faker faker = new Faker();

        int numberOfArtists = 10;
        int numberOfAlbumsPerArtist = 2;
        int numberOfGenres = 6;

        // Generate fake genres
        List<Genre> genres = new ArrayList<>();
        for (int i = 0; i < numberOfGenres; i++) {
            Genre genre = new Genre(faker.book().genre());
            genre = genreRepository.create(genre);
            genres.add(genre);
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfArtists; i++) {
            // Generate and insert fake artist
            Artist artist = new Artist(faker.artist().name());
            artist = artistRepository.create(artist);

            for (int j = 0; j < numberOfAlbumsPerArtist; j++) {
                // Generate and insert fake album
                Album album = new Album();
                album.setReleaseYear(1950 + faker.random().nextInt(1, 70));
                album.setTitle(faker.book().title());
                album.setArtist(artist);
                album.setGenres(new ArrayList<>(List.of(genres.get(faker.random().nextInt(numberOfGenres)))));
                albumRepository.create(album);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }
}