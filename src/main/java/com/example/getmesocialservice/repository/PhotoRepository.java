package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.model.Photo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//extends MongoRepository<UserEntity, String>
@Repository
public class PhotoRepository  {
    List<Comment> commentListPlaceholder = new ArrayList<>(List.of(
            new Comment("1","1","First Message", "Pa Strong","Jan 22 2022"),
            new Comment("2","1","Second Message", "Pa Strong","Jan 23 2022"),
            new Comment("3","1","Third Message", "Baby Strong","Jan 29 2022")
    ));
    List<Photo> photoList = new ArrayList<>(List.of(
            new Photo("1","1","www.picsum.photos/200/300", "Tex Cauffield","1976",commentListPlaceholder),
            new Photo("2","1","www.picsum.photos/400/400", "Rex Cauffield","2004",commentListPlaceholder),
            new Photo("3","1","www.picsum.photos/300/300", "Lex Luthor","1933",commentListPlaceholder)
    ));

    public Photo getPhoto(){
        Photo photo = photoList.get(photoList.size()-1);
        return photo;
    }

    public List<Photo> savePhoto(Photo photo) {
//        photo.setId(photoList.size() +1);
        photoList.add(photo);
        return photoList;
    }

    public List<Photo> getAllPhotos() {
        for(Photo photo: photoList) {
            for (Comment comment : photo.comments) {
                comment.photoId = photo.id;
            }
        }
        return photoList;
    }

    public Photo getPhotoById(String id) {
        for(Photo photo:photoList){
            if(photo.getId().equals(id)){
                return photo;
            }
        }
        return null;
    }

    public Photo deletePhoto(String id) {
        Photo deletedPhoto = null;

        for(Photo p:photoList){
            if(p.getId() == id) {
                deletedPhoto = p;
                photoList.remove(p);
                return deletedPhoto;
            }
        }
        return deletedPhoto;
    }

    public Comment saveComment(Comment comment) {
//        photo.setId(photoList.size() +1);
        commentListPlaceholder.add(comment);
        return comment;
    }
    public List<Comment> getCommentsInPhoto(String id) {

        for(Photo photo: photoList) {
            if(photo.getId().equals(id)){

                return photo.comments;
            }
        }
        return null;
    }
}
