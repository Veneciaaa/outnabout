package com.outnabout.outnaboutserver;

import org.omg.PortableInterceptor.ACTIVE;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashMap;

/**
 * Created by Josh on 2/25/17.
 */




@RestController
public class ActiveGroupController {

    @RequestMapping("/initializeActiveGroup")
    public String createActiveGroup(@RequestParam(value="userID", required=true) String userID,
                             @RequestParam(value="groupID", required=true) String groupName){

        if(!ActiveUser.allUsers.containsKey(Integer.parseInt(userID))) return null;
        ActiveGroup newGroup = new ActiveGroup(ActiveUser.allUsers.get(userID), groupName);
        return Integer.toString(newGroup.getGroupID());
    }

    @RequestMapping("/allActiveGroups")
    public HashMap<Integer, ActiveGroup> getAllActiveGroups(){
        return ActiveGroup.allgroups;
    }

}
