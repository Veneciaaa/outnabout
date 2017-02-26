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

    @RequestMapping("/createGroup")
    public String createGroup(@RequestParam(value="userid", required=true) String userID,
                             @RequestParam(value="groupname", required=true) String groupName){

        if(!ActiveUser.allUsers.containsKey(Integer.parseInt(userID))) return null;
        ActiveGroup newGroup = new ActiveGroup(ActiveUser.allUsers.get(Integer.parseInt(userID)), groupName);
        //ActiveGroup.allgroups.put(newGroup.getGroupID(), newGroup);
        return Integer.toString(newGroup.getGroupID());
    }

    @RequestMapping("/joinGroup")
    public String joinGroup(@RequestParam(value="userid", required=true) String userID,
                                    @RequestParam(value="groupid", required=true) String groupID){

        if(!ActiveGroup.allgroups.containsKey(Integer.parseInt(groupID))) return Integer.toString(-1);
        if(!ActiveUser.allUsers.containsKey(Integer.parseInt(userID))) return Integer.toString(-1);
        else ActiveGroup.allgroups.get(Integer.parseInt(groupID)).addMember(ActiveUser.allUsers.get(Integer.parseInt(userID)));
        return Integer.toString(1);
    }

    @RequestMapping("/leaveGroup")
    public String leaveGroup(@RequestParam(value="userid", required=true) String userID,
                             @RequestParam(value="groupid", required=true) String groupID){
        if(!ActiveGroup.allgroups.containsKey(Integer.parseInt(groupID))) return Integer.toString(-1);
        if(!ActiveUser.allUsers.containsKey(Integer.parseInt(userID))) return Integer.toString(-1);
        else {
            ActiveGroup.allgroups.get(Integer.parseInt(groupID)).removeMember(ActiveUser.allUsers.get(Integer.parseInt(userID)));
            return Integer.toString(1);
        }
    }

    @RequestMapping("/getGroupLocations")
    public HashMap<Integer, Double[]> getGroupLocations(@RequestParam(value="groupid") String groupID){
        if(!ActiveGroup.allgroups.containsKey(Integer.parseInt(groupID))) return null;
        else{
            return ActiveGroup.getGroupLocations(Integer.parseInt(groupID));
        }
    }

    @RequestMapping("/allActiveGroups")
    public HashMap<Integer, ActiveGroup> getAllActiveGroups(){
        return ActiveGroup.allgroups;
    }

}
