package com.spotifyclone.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spotifyclone.api.repositories.ResponseObject;
import com.spotifyclone.api.services.MusicService;

@Controller
@RequestMapping("/api/v1")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/audios")
    public ResponseEntity<ResponseObject> getAllAudios() {
        return musicService.loadAllAudios();
    }

    @GetMapping("/artists")
    public ResponseEntity<ResponseObject> getAllArtists() {
        return musicService.loadAllArtists();
    }

    @GetMapping("/albums")
    public ResponseEntity<ResponseObject> getAllAlbums() {
        return musicService.loadAllAlbums();
    }
}
