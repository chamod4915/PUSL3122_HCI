////package org.furniwise.pusl3122_hci_project.Controllers.Admin;
////
////import javafx.fxml.Initializable;
////import javafx.scene.control.ListView;
////import org.furniwise.pusl3122_hci_project.Models.Model;
////
////import java.net.URL;
////import java.util.ResourceBundle;
////
////public class AllUsersController implements Initializable {
////    public ListView<String> users_list_view;
////    public Model model;
////
////    @Override
////    public void initialize(URL location, ResourceBundle resources) {
////        model = Model.getInstance(null); // Pass null for ViewFactory as it's not required here
////        populateUsersListView();
////    }
////
////    private void populateUsersListView() {
////        // Call method from Model to get client details and populate ListView
////        users_list_view.getItems().addAll(model.getAllClients());
////    }
////}
////
////
////package org.furniwise.pusl3122_hci_project.Controllers.Admin;
////
////import javafx.fxml.FXMLLoader;
////import javafx.fxml.Initializable;
////import javafx.scene.control.ListCell;
////import javafx.scene.control.ListView;
////import javafx.util.Callback;
////import org.furniwise.pusl3122_hci_project.Models.Model;
////
////import java.io.IOException;
////import java.net.URL;
////import java.util.ResourceBundle;
////
////public class AllUsersController implements Initializable {
////    public ListView<String> users_list_view;
////    public Model model;
////
////    @Override
////    public void initialize(URL location, ResourceBundle resources) {
////        model = Model.getInstance(null); // Pass null for ViewFactory as it's not required here
////        populateUsersListView();
////    }
////
////    private void populateUsersListView() {
////        // Set custom cell factory to load UsersCell.fxml for each item in ListView
////        users_list_view.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
////            @Override
////            public ListCell<String> call(ListView<String> param) {
////                return new ListCell<String>() {
////                    @Override
////                    protected void updateItem(String item, boolean empty) {
////                        super.updateItem(item, empty);
////                        if (item == null || empty) {
////                            setGraphic(null);
////                        } else {
////                            try {
////                                // Load UsersCell.fxml for each item
////                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/UserCell.fxml"));
////                                setGraphic(loader.load());
////
////                                // Access controller and set data
////                                UserCellController controller = loader.getController();
////                                // Assuming item format is "joinedDate,firstName,lastName"
////                                String[] dataParts = item.split(",");
////                                controller.setData(dataParts[0], dataParts[1], dataParts[2]);
////                            } catch (IOException e) {
////                                e.printStackTrace();
////                            }
////                        }
////                    }
////                };
////            }
////        });
////
////        // Call method from Model to get client details and populate ListView
////        users_list_view.getItems().addAll(model.getAllClients());
////    }
////}
//
////
////package org.furniwise.pusl3122_hci_project.Controllers.Admin;
////
////import javafx.fxml.FXMLLoader;
////import javafx.fxml.Initializable;
////import javafx.scene.control.ListCell;
////import javafx.scene.control.ListView;
////import javafx.util.Callback;
////import org.furniwise.pusl3122_hci_project.Models.Model;
////
////import java.io.IOException;
////import java.net.URL;
////import java.util.ResourceBundle;
////
////public class AllUsersController implements Initializable {
////    public ListView<String> users_list_view;
////    public Model model;
////
////    @Override
////    public void initialize(URL location, ResourceBundle resources) {
////        model = Model.getInstance(null); // Pass null for ViewFactory as it's not required here
////        populateUsersListView();
////    }
////
////    private void populateUsersListView() {
////        // Set custom cell factory to load UsersCell.fxml for each item in ListView
////        users_list_view.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
////            @Override
////            public ListCell<String> call(ListView<String> param) {
////                return new ListCell<String>() {
////                    @Override
////                    protected void updateItem(String item, boolean empty) {
////                        super.updateItem(item, empty);
////                        if (item == null || empty) {
////                            setGraphic(null);
////                        } else {
////                            try {
////                                // Load UsersCell.fxml for each item
////                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/UserCell.fxml"));
////                                setGraphic(loader.load());
////
////                                // Access controller and set data
////                                UserCellController controller = loader.getController();
////                                // Split the item string by comma and check if it has enough parts
////                                String[] dataParts = item.split(",");
////                                if (dataParts.length >= 3) {
////                                    controller.setData(dataParts[0], dataParts[1], dataParts[2]);
////                                } else {
////                                    // Handle the case when dataParts does not have enough elements
////                                    System.err.println("Invalid item format: " + item);
////                                }
////                            } catch (IOException e) {
////                                e.printStackTrace();
////                            }
////                        }
////                    }
////                };
////            }
////        });
////
////        // Call method from Model to get client details and populate ListView
////        users_list_view.getItems().addAll(model.getAllClients());
////    }
////}
//
//package org.furniwise.pusl3122_hci_project.Controllers.Admin;
//
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.ListView;
//import javafx.util.Callback;
//import org.furniwise.pusl3122_hci_project.Models.Model;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class AllUsersController implements Initializable {
//    public ListView<String> users_list_view;
//    public Model model;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        model = Model.getInstance(null); // Pass null for ViewFactory as it's not required here
//        populateUsersListView();
//    }
//
//    private void populateUsersListView() {
//        // Set custom cell factory to load UsersCell.fxml for each item in ListView
//        users_list_view.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
//            @Override
//            public ListCell<String> call(ListView<String> param) {
//                return new ListCell<String>() {
//                    @Override
//                    protected void updateItem(String item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (item == null || empty) {
//                            setGraphic(null);
//                        } else {
//                            try {
//                                // Load UsersCell.fxml for each item
//                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/UserCell.fxml"));
//                                loader.load(); // Load the FXML file
//                                // Access controller
//                                UserCellController controller = loader.getController();
//                                // Assuming item format is "joinedDate,firstName,lastName"
//                                String[] dataParts = item.split(",");
//                                if (dataParts.length >= 3) {
//                                    // Call setData method to set data in labels
//                                    controller.setData(dataParts[0], dataParts[1], dataParts[2]);
//                                    setGraphic(controller.getRoot()); // Set the graphic
//                                } else {
//                                    // Handle the case when dataParts does not have enough elements
//                                    System.err.println("Invalid item format: " + item);
//                                }
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                };
//            }
//        });
//
//        // Call method from Model to get client details and populate ListView
//        users_list_view.getItems().addAll(model.getAllClients());
//    }
//}
//


package org.furniwise.pusl3122_hci_project.Controllers.Admin;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.furniwise.pusl3122_hci_project.Models.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllUsersController implements Initializable {
    public ListView<String> users_list_view;
    public Model model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = Model.getInstance(null); // Pass null for ViewFactory as it's not required here
        populateUsersListView();
    }

    private void populateUsersListView() {
        // Set custom cell factory to load UsersCell.fxml for each item in ListView
        users_list_view.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            try {
                                // Parse the item data here before setting it in the UserCellController
                                String[] dataParts = item.split("\\|"); // Assuming the data is separated by "|"
//                                System.out.print(dataParts);
                                if (dataParts.length >= 7) { // Check if the dataParts array has enough elements
//                                    String joinedDate = dataParts[4].trim();
//                                    String firstName = dataParts[1].trim();
//                                    String lastName = dataParts[2].trim();

                                    String id = dataParts[0].trim();
                                    String firstName = dataParts[1].trim();
                                    String lastName = dataParts[2].trim();
                                    String payeeAddress = dataParts[3].trim();
                                    String joinedDate = dataParts[4].trim();
                                    String username = dataParts[5].trim();
                                    String email = dataParts[6].trim();
                                    // Load UsersCell.fxml for each item
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/UserCell.fxml"));
                                    loader.load(); // Load the FXML file

                                    // Access controller
                                    UserCellController controller = loader.getController();
                                    // Set data in the controller
//                                    controller.setData(joinedDate, firstName, lastName);
                                    System.out.println(id);
                                    System.out.println(username);

                                    System.out.println(email);

                                    System.out.println(id);

                                    controller.setData(id, firstName, lastName, payeeAddress, joinedDate, username, email);
                                    setGraphic(controller.getRoot()); // Set the graphic
                                } else {
                                    // Handle the case when dataParts does not have enough elements
                                    System.err.println("Invalid item format: " + item);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
            }
        });

        // Call method from Model to get client details and populate ListView
        users_list_view.getItems().addAll(model.getAllClients());
    }
}
