package com.outnabout.outnaboutserver;

import javax.sql.DataSource;

/**
 * Created by francisco on 2/25/17.
 */

import java.sql.SQLException;
import java.util.List;
import java.util.StringJoiner;
import javax.sql.DataSource;

import com.outnabout.outnaboutserver.ActiveUser;
import com.outnabout.outnaboutserver.DAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.*;
import org.springframework.jdbc.core.JdbcTemplate;


public class JDBCTemplate  implements DAO{

    private DataSource datasource;
    private JdbcTemplate jdbctemplate;

    public void setDataSource(DataSource ds){
        datasource = ds;
        try {
            datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbctemplate = new JdbcTemplate(datasource);
    }

    public JDBCTemplate(DataSource ds){
        setDataSource(ds);
    }

    @Override
    public void createUser(ActiveUser user){
        String query = "insert into app.User (User_Id, First_Name, Last_Name, Username) values (";
        query += user.getUserID();
        query += "'" + user.getFirstname() + "'";
        query += "'" + user.getLastname() + "'";
        query += "'" + user.getUsername() + "'";

        jdbctemplate.setDataSource(datasource);
        jdbctemplate.update(query);
    }

    //@Override
    public ActiveUser getUserByID(int id){
        return null;
    }

    //@Override
    public ActiveUser getUserByName(String name){
        return null;
    }
}
