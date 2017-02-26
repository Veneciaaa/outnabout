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

        if(allgroups == null) allgroups = new HashMap<Integer, ActiveGroup>();

        //if(!ActiveUser.allUsers.containsValue(first)) return;

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

    public ArrayList<ActiveUser> getMembers(){
        return members;
    }

    public static HashMap<Integer, Double[]> getGroupLocations(int groupID){
        HashMap<Integer, Double[]> locations = null;
        if(!allgroups.containsKey(groupID)) return locations;
        else{
            locations = new HashMap<Integer,Double[]>();
            for(int i = 0; i < allgroups.get(groupID).getMembers().size(); i++){
                Double[] location = {allgroups.get(groupID).getMembers().get(i).getLatitude(),
                        allgroups.get(groupID).getMembers().get(i).getLongitude()};
                locations.put(allgroups.get(groupID).getMembers().get(i).getUserID(), location);
            }
            return locations;
        }
    }

    public void killGroup(){
        allgroups.remove(this);
    }

}
