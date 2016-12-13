package com.example.guest.addressbook.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 12/13/16.
 */
@Parcel
public class Contact {
    String name;
    String phone;
    String email;
    String street;
    String city;
    String state;
    String zip;
    String photoUrl;
    String socialMediaUrl;
    private String pushId;

    public Contact(String phone, String name, String email, String street, String city, String state, String zip, String photoUrl, String socialMediaUrl) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.photoUrl = photoUrl;
        this.socialMediaUrl = socialMediaUrl;
    }

    public Contact(String name) {
        this.name = name;
    }

    public Contact() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getSocialMediaUrl() {
        return socialMediaUrl;
    }

    public void setSocialMediaUrl(String socialMediaUrl) {
        this.socialMediaUrl = socialMediaUrl;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
