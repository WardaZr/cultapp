package com.tubes.kelompok9.cultapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class ContentNotes implements Parcelable {
    private int id;
    private String judul;
    private int imgId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getImgid() {
        return imgId;
    }

    public void setImgid(int imgId) {
        this.imgId = imgId;
    }

    public ContentNotes(String judul, int imgId) {
        this.judul = judul;
        this.imgId = imgId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.judul);
        dest.writeInt(this.imgId);
    }

    protected ContentNotes(Parcel in) {
        id = in.readInt();
        judul = in.readString();
        imgId = in.readInt();
    }

    public static final Creator<ContentNotes> CREATOR = new Creator<ContentNotes>() {
        @Override
        public ContentNotes createFromParcel(Parcel in) {
            return new ContentNotes(in);
        }

        @Override
        public ContentNotes[] newArray(int size) {
            return new ContentNotes[size];
        }
    };
}
