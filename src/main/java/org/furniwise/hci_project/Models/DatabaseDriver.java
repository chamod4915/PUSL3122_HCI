package org.furniwise.pusl3122_hci_project.Models;

import java.sql.*;

public class DatabaseDriver {

    private Connection conn;

    public DatabaseDriver(){
        try{
            this.conn = DriverManager.getConnection("jdbc:sqlite:furniwise_database.db");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public ResultSet getAllClientsData() {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

//    Client Section

    public ResultSet getClientData(String pAddress,String password){
        Statement statement;
        ResultSet resultSet = null;

        try{
            statement = this.conn.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password='"+password+"';");


        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAdminData(String username, String password) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.conn.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username='"+username+"' AND Password='"+password+"';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
