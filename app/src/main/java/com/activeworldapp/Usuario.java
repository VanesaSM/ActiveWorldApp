package com.activeworldapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Usuario implements Parcelable{

    public Usuario(String username, int password, int id_us) {
        this.username = username;
        this.password = password;
        this.id_us = id_us;
    }

    public String username;


    public Usuario(String username, int password) {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getId_us() {
        return id_us;
    }

    public void setId_us(int id_us) {
        this.id_us = id_us;
    }

    public int password;
    public int id_us;

    @Override
    public String toString() {
        return "Usuario";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeInt(this.password);
        dest.writeInt(this.id_us);
    }

    public void readFromParcel(Parcel source) {
        this.username = source.readString();
        this.password = source.readInt();
        this.id_us = source.readInt();
    }

    protected Usuario(Parcel in) {
        this.username = in.readString();
        this.password = in.readInt();
        this.id_us = in.readInt();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel source) {
            return new Usuario(source);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}
