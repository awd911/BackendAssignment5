package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;


    public List<Photo> savePhoto(Photo photo) {
        return photoRepository.savePhoto(photo);
    }

    public Photo getPhoto() {
        return photoRepository.getPhoto();
    }

    public List<Photo> getAllPhotos(){return photoRepository.getAllPhotos();}

    public Photo getPhotoById(String id) {
        return photoRepository.getPhotoById(id);
    }

    public Photo deletePhoto(String id) {
        return photoRepository.deletePhoto(id);
    }

    public List<Comment> getCommentsInPhoto(String id) { return photoRepository.getCommentsInPhoto(id);}

    public Comment saveComment(Comment comment) {
        return photoRepository.saveComment(comment);
    }
}