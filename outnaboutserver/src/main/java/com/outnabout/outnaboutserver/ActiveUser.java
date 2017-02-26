package com.outnabout.outnaboutserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Josh on 2/25/17.
 */
public class ActiveUser {

    private class Drink{

        int abv;
        String name;

        public Drink(int _abv, String _name){
            abv = _abv;
            name = _name;
        }

        public int getAbv() {
            return abv;
        }

        public void setAbv(int abv) {
            this.abv = abv;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    private ArrayList<Drink> drinks;

    public int getDrinkCount() {
        return drinkCount;
    }

    public void setDrinkCount(int drinkCount) {
        this.drinkCount = drinkCount;
    }

    private int drinkCount;
    private String name;
    private int userID;
    private double latitude;
    private double longitude;

    public static HashMap<Integer, ActiveUser> allUsers;

    public ActiveUser(int _userID, String _name, double _latitude, double _longitude){
        drinks = new ArrayList<Drink>();
        name = _name;
        userID = _userID;
        latitude = _latitude;
        longitude = _longitude;
        if(allUsers == null) allUsers = new HashMap<Integer, ActiveUser>();
        allUsers.put(userID, this);
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void addDrink(int abv, String name){
        drinks.add(new Drink(abv, name));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


}
