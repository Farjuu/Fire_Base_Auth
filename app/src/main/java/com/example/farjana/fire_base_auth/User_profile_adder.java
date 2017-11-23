package com.example.farjana.fire_base_auth;

/**
 * Created by Farjana on 10/31/2017.
 */

public class User_profile_adder {

    String email;
    String name;
    String designation;
    String department;
    String bitmap;

    public User_profile_adder(){

   }

    public User_profile_adder(  String email, String name, String designation, String department,String bitmap) {

        this.email = email;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.bitmap = bitmap;
    }



    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public String getBitmap() {
        return bitmap;
    }
}
