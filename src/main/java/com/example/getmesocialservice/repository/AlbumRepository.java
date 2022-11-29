package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

//    List<Photo> photoList = new ArrayList<>(List.of(
//            new Photo("1","AlbumId1","www.placecage.com/200/300", "Tex Cauffield","1976"),
//            new Photo("2","AlbumId2","www.placecage.com/400/400", "Rex Cauffield","2004"),
//            new Photo("3","AlbumId3","www.placecage.com/300/300", "Lex Luthor","1933")
//    ));
//
//C/O https://placeholder.com/#How_To_Use_Our_Placeholders

    List<Album> albumList = new ArrayList<>(List.of(
            new Album("1","Disco Tex", "Tex Cauffield", null,"1976","https://via.placeholder.com/150"),
            new Album("2","Disco Rex 2", "Rex Cauffield", null,"2004","https://via.placeholder.com/150"),
            new Album("3","Disco Lex 3", "Lex Luthor", null,"1933","https://via.placeholder.com/150")
    ));

    public Album getAlbum(){
        Album album = albumList.get(albumList.size()-1);
        return album;
    }

    public Album saveAlbum(Album album) {
        albumList.add(album);
        return album;
    }

    public List<Album> getAllAlbums() {
        for(Album album: albumList){
            for(Photo photo: album.coverPhotos){
                photo.albumId = album.id;
            }
        }

        return albumList;
    }

    public Album getAlbumById(String id) {
        for(Album album: albumList){
            if(album.getid().equals(id)){
                return album;
            }
        }
        return null;
    }
    public List<Photo> getPhotosInAlbum(String id) {
        for(Album album: albumList){
            if(album.getid().equals(id)){
                return album.coverPhotos;
            }
        }
        return null;
    }


    public Album setAlbumPhoto(String id, String albumPhoto)
    {
        for(Album a:albumList){
            if(a.getid().equals(id)){
                a.setAlbumPhoto(albumPhoto);

                return a;
            }
        }
        return null;


    }

    public Album deleteAlbum(String albumId) {
        Album deletedAlbum = null;

        for(Album u:albumList){
            if(u.getid() == albumId){
                deletedAlbum = u;
                albumList.remove(u);
                return deletedAlbum;
            }

        }
        return deletedAlbum;
    }


}