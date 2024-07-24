package com.codegym.musicapp.service;

import com.codegym.musicapp.model.Song;

public interface ISongService {
    Iterable<Song> findAll();

    void save(Song song);

    void deleteById(Long id);

    Song findById(Long id);
}
