package com.outnabout.outnaboutserver;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Josh on 2/25/17.
 */
public class ActiveGroup {

    private int groupID;
    private String groupName;
    private ArrayList<ActiveUser> members;

    public static HashMap<Integer, ActiveGroup> allgroups;
    private static int currentGroupID = 0;

    public ActiveGroup(ActiveUser first, String _groupName){
        members = new ArrayList<ActiveUser>();

        if(!ActiveUser.allUsers.containsValue(first)) return;

        members.add(first);
        groupName = _groupName;
        groupID = currentGroupID;
        currentGroupID++;
        allgroups.put(groupID, this);

    }

    public int getGroupID(){
        return groupID;
    }

    public void addMember(ActiveUser newMember){
        members.add(newMember);
    }

    public void removeMember(ActiveUser oldMember){
        members.remove(oldMember);
        if(members.isEmpty()) killGroup();
    }

    public void killGroup(){
        allgroups.remove(this);
    }

}
