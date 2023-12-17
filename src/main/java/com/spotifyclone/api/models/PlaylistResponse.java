package com.spotifyclone.api.models;

import java.util.ArrayList;
import java.util.List;

public class PlaylistResponse {
    private long id;
    private String name;
    private List<AudioLite> audios;
    private String avatar;
    
    public PlaylistResponse() {}

    public PlaylistResponse(long id, String name, List<AudioLite> audios, String avatar) {
        this.id = id;
        this.name = name;
        this.audios = audios;
        this.avatar = avatar;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<AudioLite> getAudios() {
        return this.audios;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAudios(List<AudioLite> audios) {
        this.audios = audios;
    }

    public void modifyAudios(AudioLite audio) {
        if(this.audios == null) this.audios = new ArrayList<>();

        this.audios.add(audio);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
