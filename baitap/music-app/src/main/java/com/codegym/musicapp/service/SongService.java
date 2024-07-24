package com.codegym.musicapp.service;

import com.codegym.musicapp.model.Song;
import com.codegym.musicapp.repository.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepo songRepo;

    @Override
    public Iterable<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public void save(Song song) {
        songRepo.save(song);
    }

    @Override
    public void deleteById(Long id) {
        songRepo.deleteById(id);
    }

    @Override
    public Song findById(Long id) {
        return songRepo.findById(id).orElse(null);
    }
}
