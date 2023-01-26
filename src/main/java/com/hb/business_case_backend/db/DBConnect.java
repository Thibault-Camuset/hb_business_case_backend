package com.hb.business_case_backend.db;

import com.hb.business_case_backend.exception.CantOpenConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {

    public static Connection getDBConnection() throws CantOpenConnectionException {

        try {

            return DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/hb_business_case",
                    "root",
                    ""

            );

        } catch (SQLException e) {

            e.printStackTrace();
            throw new CantOpenConnectionException();

        }


    }




    public static void closeAll(PreparedStatement psmt, ResultSet rs) {

        try {

            rs.close();

        } catch (Exception e) {

        }



        try {

            psmt.close();

        } catch (Exception e) {

        }



    }

    public static void closePsmt(PreparedStatement psmt) {

        try {

            psmt.close();

        } catch (Exception e) {

        }
    }


}