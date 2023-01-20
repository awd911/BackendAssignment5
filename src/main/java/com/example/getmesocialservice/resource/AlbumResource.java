package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.Exception.exception;
import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.model.firebaseUser;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.service.FirebaseService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
    private  AlbumService albumService;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping("/album")
    public Album getAlbum(){
        return albumService.getAlbum();
    }

    @GetMapping("/albums")
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/album/{id}/photos")
    public List<Photo> getPhotosInAlbum(@PathVariable("id") String id){
        return albumService.getPhotosInAlbum(id);
    }

    @GetMapping("/album/{id}")
    public Album getAlbumById(@PathVariable("id") String id){
        return albumService.getAlbumById(id);
    }

    @GetMapping("/album/{id}/uploadPhoto")
    public Album addPhotoToAlbum(@PathVariable("id") String id, Photo photo){return albumService.addPhotoToAlbum(id,photo);}

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody @Valid Album album, @RequestHeader(name ="idToken") String idToken ) throws exception, FirebaseAuthException, IOException
    {
        firebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser !=null){
            return albumService.saveAlbum(album);
        }

        return null;
    }

    @DeleteMapping("/album")
    public Album deleteAlbum(@RequestParam(name="id") String id, @RequestBody User user, @RequestHeader(name ="idToken") String idToken ) throws exception,FirebaseAuthException, IOException
    {
        firebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser !=null) {
            return albumService.deleteAlbum(id);
        }
        return null;
    }
    @PutMapping("/album/coverPhoto")
    public void setAlbumPhoto(@RequestParam(name= "albumPhoto") String albumPhoto, @RequestParam(name= "albumId") String albumId )
    {

            albumService.setAlbumPhoto(albumPhoto, albumId);

    }
}