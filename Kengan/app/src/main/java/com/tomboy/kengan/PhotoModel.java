package com.tomboy.kengan;

public class PhotoModel {
    private String photoName;
    private String photoId;

    public PhotoModel() {
    }

    public PhotoModel(String photoName, String photoId) {
        this.photoName = photoName;
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhoto() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }
}
