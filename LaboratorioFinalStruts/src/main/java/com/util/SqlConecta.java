/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

/**
 *
 * @author JAVA_LM
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConecta {

    private final String db;

    public SqlConecta() {
        db = "parainfo"; 
    }

    public Connection connection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + db, "root", "sasa");

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        }

        return cn;
    }
}

