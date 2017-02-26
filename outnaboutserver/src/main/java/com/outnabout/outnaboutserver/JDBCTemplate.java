package com.outnabout.outnaboutserver;

import javax.sql.DataSource;

/**
 * Created by francisco on 2/25/17.
 */

import java.util.List;
import java.util.StringJoiner;
import javax.sql.DataSource;

import com.outnabout.outnaboutserver.ActiveUser;
import com.outnabout.outnaboutserver.DAO;
import org.springframework.jdbc.*;
import org.springframework.jdbc.core.JdbcTemplate;


public class JDBCTemplate  {

    private DataSource datasource;
    private JdbcTemplate jdbctemplate;

    public void setDataSource(DataSource ds){
        datasource = ds;
        jdbctemplate = new JdbcTemplate();
    }

//    @Override
//    public void createUser(ActiveUser user){
//        String query = "insert into app.User (User_Id, First_Name, Last_Name, Username) values (";
//        query += user.getUserID();
//        query += user.getFirstName();
//        query += user.getLastName();
//        query += user.getUsername();
//
//        jdbctemplate.update(query);
//    }

    //@Override
    public ActiveUser getUserByID(int id){
        return null;
    }

    //@Override
    public ActiveUser getUserByName(String name){
        return null;
    }
}
