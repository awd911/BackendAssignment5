package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.Exception.exception;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.model.firebaseUser;
import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PhotoResource {

    @Autowired
    private FirebaseService firebaseService;

    @Autowired
    private PhotoService photoService;

    @GetMapping("/photo")
    public Photo getPhoto() {
        return photoService.getPhoto();
    }

    @GetMapping("/photos")
    public List<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping("/photo/{id}")
    public Photo getPhotoById(@PathVariable("id") String id) {
        return photoService.getPhotoById(id);
    }

    @PostMapping("/photo")
    public List<Photo> savePhoto(@RequestBody @Valid Photo photo, @RequestHeader(name = "idToken") String idToken) throws exception, FirebaseAuthException, IOException {
        firebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if (firebaseUser != null) {
            return photoService.savePhoto(photo);
        }
        return null;
    }

    @DeleteMapping("/photo")
    public Photo deletePhoto(@RequestParam(name = "id") String id, @RequestBody User user, @RequestHeader(name = "idToken") String idToken) throws exception, FirebaseAuthException, IOException {

        firebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if (firebaseUser != null) {
            return photoService.deletePhoto(id);
        }
        return null;
    }

    @GetMapping("/photo/{id}/comments")
    public List<Comment> getCommentsInPhoto(@PathVariable("id") String id) {
        return photoService.getCommentsInPhoto(id);
    }

    @PostMapping("/photo/comment")
    public Comment saveComment(@RequestBody @Valid Comment comment) {

        return photoService.saveComment(comment);

    }
}