package com.spotifyclone.api.services;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        try {
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

        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("400", "Something wrong", e.getMessage())
                );
        }     
    }

    public ResponseEntity<ResponseObject> loadAllArtists() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("200", "Get audio list successfully", artistRepository.findAll())
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("400", "Something wrong", e.getMessage())
                );
        }     
    }

    public ResponseEntity<ResponseObject> loadAllAlbums() {
        try {
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
            
                String formatCreatedAt = album.getCreatedAt().toString();
                newAlbum.setCreatedAt(formatCreatedAt);

                albums.add(newAlbum);
            }

            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("200", "Get audio list successfully", albums)
                );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("400", "Something wrong", e.getMessage())
                );
        }
    }

    public ResponseEntity<ResponseObject> addNewAudio(Audio newAudio) {
        try {
            String name = newAudio.getName();
            List<Long> artists = new ArrayList<>();
            artists = newAudio.getArtists();
            List<Long> albums = new ArrayList<>();
            albums = newAudio.getAlbums();
            String url = newAudio.getUrl();

            Boolean checkExistArtist = true;
            Boolean checkExistAlbum = true;

            // Check bad request
            if(name == null || artists == null || albums == null || url == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("401", "Bad new audio request", newAudio)
                    );
            }

            // Check exist artist
            for (Long artist : artists) {
                Optional<Artist> targetArtist = artistRepository.findById(artist);

                if(!targetArtist.isPresent()) {
                    checkExistArtist = false;
                }
            }

            if(checkExistArtist == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Artists not found", newAudio)
                    );
            }

            // Check exist album
            for (Long album : albums) {
                Optional<Album> targetAlbum = albumRepository.findById(album);

                if(!targetAlbum.isPresent()) {
                    checkExistAlbum = false;
                }
            }

            if(checkExistAlbum == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Albums not found", newAudio)
                    );
            }

            // Save new audio
            audioRepository.save(newAudio);

            // Save albums
            List<Album> albumSrc = albumRepository.findAll();

            for (Album album : albumSrc) {
                for (Long albumData : newAudio.getAlbums()) {
                    if(album.getId() == albumData) {
                        album.modifyAudios(newAudio.getId());
                        albumRepository.save(album);
                    }
                }
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseObject("201", "Add new audio successfully", newAudio)
                );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("400", "Something wrong", e.getMessage())
                );
        }
    }

    public ResponseEntity<ResponseObject> deleteAudioById(long id) {
        try {
            Optional<Audio> targetAudio = audioRepository.findById(id);

            if(!targetAudio.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Audio not found", id)
                    );
            }

            // Delete audio
            audioRepository.deleteById(id);

            // Delete audio from albums
            List<Album> albumSrc = albumRepository.findAll();

            for (Album album : albumSrc) {
                for (Long audio : album.getAudios()) {
                    if(audio == id) {
                        album.filterAudios(id);

                        albumRepository.save(album);
                    }
                }
            }

            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("201", "Delete audio successfully", id)
                );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("400", "Something wrong", e.getMessage())
                );
        }
    }

    public ResponseEntity<ResponseObject> addNewAlbum(Album newAlbum) {
        try {
            if(newAlbum.getName() == null || newAlbum.getAudios() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("401", "Bad new album request", newAlbum)
                    );
            }
          
            // Created-at
            newAlbum.setCreatedAt(new Date());

            albumRepository.save(newAlbum);

            return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseObject("201", "Add new album successfully", newAlbum)
                );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("400", "Something wrong", e.getMessage())
                );
        }
    }

     public ResponseEntity<ResponseObject> editAlbum(Album editAlbum) {
        try {
            if(editAlbum.getName() == null || editAlbum.getAudios() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("401", "Bad edit album request", editAlbum)
                    );
            }

            List<Album> albumSrc = albumRepository.findAll();
            Optional<Album> targetAlbum = albumRepository.findById(editAlbum.getId());

            if(!targetAlbum.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Album not found", editAlbum)
                    );
            }

            // Update album
            for (Album album : albumSrc) {
                if(album.getId() == editAlbum.getId()) {
                    album.setName(editAlbum.getName());
                    album.setAudios(editAlbum.getAudios());
                    albumRepository.save(album);
                }
            }

            // Add audio to album if not exist
            // for (Long audio : editAlbum.getAudios()) {
            //     if(!editAlbum.getAudios().contains(audio)) {
            //         editAlbum.modifyAudios(audio);
            //     }
            // }
            

            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("201", "Edit album successfully", editAlbum)
                );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("400", "Something wrong", e.getMessage())
                );
        }
    }

    public ResponseEntity<ResponseObject> deleteAlbumById(long id) {
        try {
            Optional<Album> targetAlbum = albumRepository.findById(id);

            if(!targetAlbum.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Album not found", id)
                    );
            }

            albumRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("201", "Delete album successfully", id)
                );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("400", "Something wrong", e.getMessage())
                );
        }
    }
}
