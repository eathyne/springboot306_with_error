package com.example.springboot306;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping("/")
    public String index(Model model){

// First let’s create an album
        Album album = new Album();

        album.setName("Forest Hills");
        album.setType("Rap");

// Now let’s create a song
        Song song = new Song();
        song.setTitle("Fire Squad");
        song.setYear(2014);
        song.setDescription("JCole is back");

// Add the movie to an empty list
        Set<Song> songs = new HashSet<Song>();
        songs.add(song);

        song = new Song();
        song.setTitle("Two Cities");
        song.setYear(2014);
        song.setDescription("boffum");
        songs.add(song);

// Add the list of movies to the director’s movie list
        album.setSongs(songs);

// Save the director to the database
        albumRepository.save(album);

// Grab all the directors from the database and send them to
// the template
        model.addAttribute("albums", albumRepository.findAll());

        return "index";
    }
}


