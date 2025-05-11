//package org.furniwise.pusl3122_hci_project.Models;
//
//import org.furniwise.pusl3122_hci_project.Views.ViewFactory;
//
//public class Model {
//
//    private static Model model;
//
//    private final ViewFactory viewFactory ;
//
//
//    private Model() {
//
//        this.viewFactory = viewFactory;
//    }
//
//    public static synchronized Model getInstance(){
//        if(model == null){
//            model = new Model();
//        }
//
//        return model;
//    }
//
//    public ViewFactory getViewFactory(){
//        return viewFactory;
//    }
//}


package org.furniwise.pusl3122_hci_project.Models;

import javafx.scene.chart.PieChart;
import org.furniwise.pusl3122_hci_project.Views.AccountType;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Model {

    private static Model model;
    private final ViewFactory viewFactory;

    private String loggedInUsername = "Admin";

    private final DatabaseDriver databaseDriver;

    private AccountType loginAccountType = AccountType.CLIENT;

    private Client client;
    private  Admin admin;
    private boolean clientLoginSuccessFlag;
    private boolean adminLoginSuccessFlag;
    private String loggedInUserId;
    private String loggedInUserEmail;

    private int totalClientRecords;

    // Private constructor with ViewFactory parameter
    private Model(ViewFactory viewFactory) {

        this.viewFactory = viewFactory;
        this.databaseDriver = new DatabaseDriver();

//        Client Data Section

        this.clientLoginSuccessFlag = false;
        this.client = new Client("","","",null,null,null,null,null);
        this.admin = new Admin("","","");

//        Admin Data Section
    }

    // Static method to get singleton instance of Model
    public static synchronized Model getInstance(ViewFactory viewFactory){
        if(model == null){
            model = new Model(viewFactory); // Pass ViewFactory instance to constructor
        }
        return model;
    }

    // Getter method for viewFactory
    public ViewFactory getViewFactory(){
        return viewFactory;
    }

    public  DatabaseDriver getDatabaseDriver(){return databaseDriver;}

    public AccountType getLoginAccountType(){
        return this.loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType){
        this.loginAccountType = loginAccountType;
    }


//    Client Method Section

    public boolean getClientLoginSuccessFlag(){return this.clientLoginSuccessFlag;};

    public void setClientLoginSuccessFlag(boolean flag){this.clientLoginSuccessFlag = flag;};

    public Client getClient(){
        return client;
    }
    public boolean getAdminLoginSuccessFlag(){return this.adminLoginSuccessFlag;};

    public void setAdminLoginSuccessFlag(boolean flag){this.adminLoginSuccessFlag = flag;};
    public Admin getAdmin(){
        return admin;
    }

    // Method to set the username of the logged-in user
    public void setLoggedInUsername(String username) {
        this.loggedInUsername = username;
    }

    // Method to get the username of the logged-in user
    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    public void setLoggedInUserID(String id) {
        this.loggedInUserId = id;
    }

    // Method to get the username of the logged-in user
    public String getLoggedInUserID() {
        return loggedInUserId;
    }

    public void setLoggedInUserEmail(String email) {
        this.loggedInUserEmail = email;
    }

    // Method to get the username of the logged-in user
    public String getLoggedInUserEmail() {
        return loggedInUserEmail;
    }
    public List<String> getAllClients() {
        List<String> clientDetailsList = new ArrayList<>();

        try {
            ResultSet resultSet = databaseDriver.getAllClientsData();

            // Loop through the result set and add client details to the list
            while (resultSet.next()) {
                String clientDetails = resultSet.getString("Id") + " | " +
                        resultSet.getString("FirstName") + " | " +
                        resultSet.getString("LastName") + " | " +
                        resultSet.getString("PayeeAddress") + " | " +
                        resultSet.getString("Date") + " | " +
                        resultSet.getString("Username") + " | " +
                        resultSet.getString("Email");
                clientDetailsList.add(clientDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientDetailsList;
    }

    public int getTotalClientRecords() {
        return totalClientRecords;
    }

    // Method to set the total count of records in the Clients table
    public void setTotalClientRecords(int totalClientRecords) {
        this.totalClientRecords = totalClientRecords;
    }
    // Method to fetch the total count of records from the Clients table in the database
    public void fetchTotalClientRecords() {
        try {
            // Prepare the SQL query to count the number of records in the Clients table
            String sql = "SELECT COUNT(*) FROM Clients";
            PreparedStatement statement = databaseDriver.getConnection().prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set has data
            if (resultSet.next()) {
                // Extract the total count from the result set and set it in the variable
                this.totalClientRecords = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateUserInfoAdmin(String id, String username, String email,String password) {
        try {
            String sql = "UPDATE Clients SET Username = ?, Email = ?, Password = ? WHERE ID = ?";
            PreparedStatement statement = databaseDriver.getConnection().prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);

            statement.setString(4, id);

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUserInformation(String id, String username, String email) {
        try {
            String sql = "UPDATE Clients SET Username = ?, Email = ? WHERE ID = ?";
            PreparedStatement statement = databaseDriver.getConnection().prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, id);

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePassword(String id, String newPassword) {
        try {
            String sql = "UPDATE Clients SET Password = ? WHERE ID = ?";
            PreparedStatement statement = databaseDriver.getConnection().prepareStatement(sql);

            statement.setString(1, newPassword);
            statement.setString(2, id);

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getUserData(String id) {
        try {
            String sql = "SELECT * FROM Clients WHERE ID = ?";
            PreparedStatement statement = databaseDriver.getConnection().prepareStatement(sql);

            statement.setString(1, id);

            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteUser(String userId) {
        try {
            String sql = "DELETE FROM Clients WHERE ID = ?";
            PreparedStatement statement = databaseDriver.getConnection().prepareStatement(sql);

            statement.setString(1, userId);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean performSignUp(String username, String email, String password) {
        try {
            // Prepare SQL statement for inserting a new record into the Clients table
            String sql = "INSERT INTO Clients (FirstName, LastName, PayeeAddress, Password, Date, Username, Email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = databaseDriver.getConnection().prepareStatement(sql);
            LocalDate currentDate = LocalDate.now();

            // Set values for the parameters
            statement.setString(1, username); // You can set appropriate values for FirstName and LastName if available
            statement.setString(2, username); // You can set appropriate values for FirstName and LastName if available
            statement.setString(3, email); // You can set appropriate values for PayeeAddress if available
            statement.setString(4, password);
            statement.setString(5, currentDate.toString()); // You can set appropriate values for Date if available
            statement.setString(6, username);
            statement.setString(7, email);

            // Execute the SQL statement to insert the new record
            int rowsInserted = statement.executeUpdate();

            // Check if the record was successfully inserted
            if (rowsInserted > 0) {
                return true; // Signup successful
            } else {
                return false; // Signup failed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Signup failed
        }
    }

    public void evaluateClientCred(String pAddress,String password){
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;

        ResultSet resultSet = databaseDriver.getClientData(pAddress,password);

        try{
            if(resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.pAddressProperty().set(resultSet.getString("PayeeAddress"));
                this.client.emailProperty().set(resultSet.getString("Email"));
                this.client.userNameProperty().set(resultSet.getString("Username"));
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateProperty().set(date);
                this.loggedInUsername = resultSet.getString("Username");
                this.setLoggedInUsername(resultSet.getString("Username"));
                this.loggedInUserId = resultSet.getString("ID");
                this.loggedInUserEmail = resultSet.getString("Email");
//                checkingAccount = getCheckingAccount(pAddress);
//                savingsAccount = getSavingsAccount(pAddress);
//                this.client.checkingAccountProperty().set(checkingAccount);
//                this.client.savingsAccountProperty().set(savingsAccount);
                this.clientLoginSuccessFlag = true;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void evaluateAdminCred(String username, String password) {
        ResultSet resultSet = databaseDriver.getAdminData(username, password);

        try {
            if (resultSet.isBeforeFirst()) {
                // Admin credentials are valid
                this.admin.usernameProperty().set(resultSet.getString("Username"));
                this.admin.passwordProperty().set(resultSet.getString("Password"));


//                checkingAccount = getCheckingAccount(pAddress);
//                savingsAccount = getSavingsAccount(pAddress);
//                this.client.checkingAccountProperty().set(checkingAccount);
//                this.client.savingsAccountProperty().set(savingsAccount);
                this.adminLoginSuccessFlag = true;
                setLoginAccountType(AccountType.ADMIN);
                // You can perform actions based on admin login success
            }
//            else {
//                // Admin credentials are invalid
//                // You can handle the case where login fails
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public void evaluateAdminCred(String username, String password) {
//        ResultSet resultSet = databaseDriver.getAdminData(username, password);
//
//        try {
//            if (resultSet.isBeforeFirst()) {
//                // Admin credentials are valid
//                // You can perform actions based on admin login success
//            } else {
//                // Admin credentials are invalid
//                // You can handle the case where login fails
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
