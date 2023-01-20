package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.model.Album;
import org.springframework.web.bind.annotation.*;
import com.example.getmesocialservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@CrossOrigin
@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album getAlbum(){
        return albumRepository.getAlbum();
    }

    public Album saveAlbum(Album album) { return albumRepository.saveAlbum(album);
    }

    public List<Album> getAllAlbums() {
        return albumRepository.getAllAlbums();
    }

    public Album getAlbumById(String id) {
        return albumRepository.getAlbumById(id);
    }

    public Album deleteAlbum(String id) {
       return albumRepository.deleteAlbum(id);
    }

    public Album addPhotoToAlbum(String id,Photo photo){ return albumRepository.addPhotoToAlbum(id,photo);}

    public List<Photo> getPhotosInAlbum(String id) { return albumRepository.getPhotosInAlbum(id);}

    public Album setAlbumPhoto(String albumPhoto, String albumId){ return albumRepository.setAlbumPhoto(albumPhoto,albumId); }

}