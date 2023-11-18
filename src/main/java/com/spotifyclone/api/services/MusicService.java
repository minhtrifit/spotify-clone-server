package com.spotifyclone.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spotifyclone.api.models.Album;
import com.spotifyclone.api.models.AlbumLite;
import com.spotifyclone.api.models.AlbumResponse;
import com.spotifyclone.api.models.Artist;
import com.spotifyclone.api.models.ArtistLite;
import com.spotifyclone.api.models.Audio;
import com.spotifyclone.api.models.AudioLite;
import com.spotifyclone.api.models.AudioResponse;
import com.spotifyclone.api.repositories.AlbumRepository;
import com.spotifyclone.api.repositories.ArtistRepository;
import com.spotifyclone.api.repositories.AudioRepository;
import com.spotifyclone.api.repositories.ResponseObject;

@Service
public class MusicService {
    @Autowired
    private AudioRepository audioRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public ResponseEntity<ResponseObject> loadAllAudios() {
        List<Audio> audioSrc = audioRepository.findAll();
        List<Artist> artistSrc = artistRepository.findAll();
        List<Album> albumSrc = albumRepository.findAll();

        List<AudioResponse> audios = new ArrayList<>();

        for (Audio audio : audioSrc) {
            AudioResponse newAudio = new AudioResponse();

            newAudio.setId(audio.getId());
            newAudio.setName(audio.getName());
            newAudio.setUrl(audio.getUrl());

            // Get artists name
            for (Long artist : audio.getArtists()) {
                for (Artist artistData : artistSrc) {
                    if(artist == artistData.getId()) {
                        newAudio.modifyArtists(new ArtistLite(artistData.getId(), artistData.getName()));
                    }
                }
            }

            // Get albums name
            for (Long album : audio.getAlbums()) {
                for (Album albumData : albumSrc) {
                    if(album == albumData.getId()) {
                        newAudio.modifyAlbums(new AlbumLite(albumData.getId(), albumData.getName()));
                    }
                }
            }

            audios.add(newAudio);
        }

        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("200", "Get audio list successfully", audios)
            );
    }

    public ResponseEntity<ResponseObject> loadAllArtists() {
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("200", "Get audio list successfully", artistRepository.findAll())
            );
    }

    public ResponseEntity<ResponseObject> loadAllAlbums() {
        List<Album> albumSrc = albumRepository.findAll();
        List<Audio> audioSrc = audioRepository.findAll();

        List<AlbumResponse> albums = new ArrayList<>();

        for (Album album : albumSrc) {
            AlbumResponse newAlbum = new AlbumResponse();

            newAlbum.setId(album.getId());
            newAlbum.setName(album.getName());

            // Get artists name
            for (Long audio : album.getAudios()) {
                for (Audio audioData : audioSrc) {
                    if(audio == audioData.getId()) {
                        newAlbum.modifyAudios(new AudioLite(audioData.getId(), audioData.getName()));
                    }
                }
            }

            albums.add(newAlbum);
        }

        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("200", "Get audio list successfully", albums)
            );
    }
}
