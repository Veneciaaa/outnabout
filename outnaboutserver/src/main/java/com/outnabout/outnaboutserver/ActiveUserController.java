package com.outnabout.outnaboutserver;

//import com.outnabout.outnaboutserver.OutnaboutserverApplication;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by Josh on 2/25/17.
 */

@RestController
public class ActiveUserController {

    @RequestMapping("/initializeActiveUser")
    public ActiveUser activeUser(@RequestParam(value="userID", defaultValue = "0") String userID) {

        //Get User Information from database using userID

        //OutnaboutserverApplication.activeUsers.add(new ActiveUser(0, "default", 0.0, 0.0));
        return new ActiveUser(Integer.parseInt(userID), "default", 0.0, 0.0);
    }

    @RequestMapping("/allActiveUsers")
    public HashMap<Integer, ActiveUser> getAllActiveUsers(){
        return ActiveUser.allUsers;
    }
}
