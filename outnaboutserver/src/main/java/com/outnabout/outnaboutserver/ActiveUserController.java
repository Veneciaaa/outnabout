package com.outnabout.outnaboutserver;

//import com.outnabout.outnaboutserver.OutnaboutserverApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by Josh on 2/25/17.
 */

@RestController
public class ActiveUserController {

//    @RequestMapping("/initializeActiveUser")
//    public ActiveUser activeUser(@RequestParam(value="userID", defaultValue = "0") String userID) {
//
//        //Get User Information from database using userID
//
//        //OutnaboutserverApplication.activeUsers.add(new ActiveUser(0, "default", 0.0, 0.0));
//        return new ActiveUser(Integer.parseInt(userID), "default", "default","default", 0.0, 0.0);
//    }

    @RequestMapping("/addNewUser")
    public String addNewUser(@RequestParam(value="firstname", required=true) String firstname,
                             @RequestParam(value="lastname", required=true) String lastname,
                             @RequestParam(value="username", required=true) String username,
                             @RequestParam(value="password", required=true) String password){
        ActiveUser au = new ActiveUser(0, username, firstname, lastname, 0.00, 0.00);
        return Integer.toString(au.getUserID());
    }

    @RequestMapping("/getDrinks")
    public String getDrinks(@RequestParam(value="userid", required=true) String userID){
        if(!ActiveUser.allUsers.containsKey(Integer.parseInt(userID))) return null;
        else return Integer.toString(ActiveUser.allUsers.get(Integer.parseInt(userID)).getDrinkCount());
    }

    @RequestMapping("/addDrink")
    public String addDrink(@RequestParam(value="userid", required=true) String userID){
        if(!ActiveUser.allUsers.containsKey(Integer.parseInt(userID))) return Integer.toString(0);
        else{
            ActiveUser.allUsers.get(Integer.parseInt(userID)).addDrinkCount();
            return Integer.toString(1);
        }
    }

    @RequestMapping("/saveUserLoc")
    public String saveUserLoc(@RequestParam(value="userid") String userID,
                              @RequestParam(value="lat") String latitude,
                              @RequestParam(value="long") String longitude){
        if(!ActiveUser.allUsers.containsKey(Integer.parseInt(userID))) return Integer.toString(0);
        else{
            ActiveUser.allUsers.get(Integer.parseInt(userID)).setLatitude(Double.parseDouble(latitude));
            ActiveUser.allUsers.get(Integer.parseInt(userID)).setLongitude(Double.parseDouble(longitude));
            return Integer.toString(1);
        }
    }

    @RequestMapping("/addShot")
    public String addShot(@RequestParam(value="userid", required=true) String userID){
        if(!ActiveUser.allUsers.containsKey(Integer.parseInt(userID))) return Integer.toString(0);
        else{
            ActiveUser.allUsers.get(Integer.parseInt(userID)).addShotCount();
            return Integer.toString(1);
        }
    }

    @RequestMapping("/getShots")
    public String getShots(@RequestParam(value="userid", required=true) String userID){
        if(!ActiveUser.allUsers.containsKey(Integer.parseInt(userID))) return null;
        else return Integer.toString(ActiveUser.allUsers.get(Integer.parseInt(userID)).getShotCount());
    }

    @RequestMapping("/allActiveUsers")
    public HashMap<Integer, ActiveUser> getAllActiveUsers(){
        return ActiveUser.allUsers;
    }
}
