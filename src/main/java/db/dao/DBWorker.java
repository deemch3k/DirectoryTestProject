package db.dao;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Дмитрий on 24.11.2016.
 */

@Getter
public class DBWorker {

    private Connection connection;

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:postgresql://localhost:5436/directory";


    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
