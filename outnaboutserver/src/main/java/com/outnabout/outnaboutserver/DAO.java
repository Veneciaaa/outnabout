package com.outnabout.outnaboutserver;

/**
 * Created by francisco on 2/25/17.
 */
import java.util.List;
import javax.sql.DataSource;
import com.outnabout.outnaboutserver.*;

public interface DAO{

    void setDataSource(DataSource ds);
    void createUser(ActiveUser user);
    ActiveUser getUserByID(int userID);
    ActiveUser getUserByName(String username);

}