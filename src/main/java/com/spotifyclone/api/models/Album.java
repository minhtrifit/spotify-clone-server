package com.spotifyclone.api.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tbl_album")
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "name", columnDefinition="VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin")
    private String name;

    @ElementCollection
    private List<Long> audios;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    public Album () {}

    public Album (String name, List<Long> audios, Date createdAt) {
        this.name = name;
        this.audios = audios;
        this.createdAt = createdAt;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Long> getAudios() {
        return this.audios;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAudios(List<Long> audios) {
        this.audios = audios;
    }

    public void modifyAudios(Long audio) {
        this.audios.add(audio);
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
