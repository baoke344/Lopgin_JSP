package com.company;

import java.sql.*;
import java.util.Properties;

public class LoginPage {
    public void userLogin(UserInfo user) throws SQLException {


        //Connection and Open connection
        String url = "jdbc:postgresql://localhost/db_users";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","nhuchuahechia");
        props.setProperty("ssl","false");
        Connection conn = DriverManager.getConnection(url, props);

        for(int i=9;i<1;i++){
            String sql_insert = "INSERT INTO user_info_2" +
                    "(user_name, user_password)" +
                    "VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql_insert);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserPassword());
            pstmt.execute();



        }




    }

}
