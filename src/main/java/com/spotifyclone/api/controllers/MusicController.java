package com.spotifyclone.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spotifyclone.api.models.Album;
import com.spotifyclone.api.models.Audio;
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

    @PostMapping("/add/audio")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')") 
    public ResponseEntity<ResponseObject> addNewAudio(@RequestBody Audio newAudio) {
        return musicService.addNewAudio(newAudio);
    }

    @PostMapping("/delete/audio/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')") 
    public ResponseEntity<ResponseObject> deleteAudio(@PathVariable long id) {
        return musicService.deleteAudioById(id);
    }

    @PostMapping("/add/album")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')") 
    public ResponseEntity<ResponseObject> addNewAlbum(@RequestBody Album newAlbum) {
        return musicService.addNewAlbum(newAlbum);
    }
}
