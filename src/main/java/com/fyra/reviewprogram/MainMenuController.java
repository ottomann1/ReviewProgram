package com.fyra.reviewprogram;

import com.fyra.reviewprogram.database.CustomerDAO;
import entity.Customer;
import entity.Review;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TESTING GIT

public class MainMenuController {

    @FXML
    private Button restaurantButton;

    @FXML
    private ListView<Customer> reviewBox;

    @FXML
    private ListView<Review> reviewsListView;

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer("Otto", "Kostmann", "123456", "otto.kostmann@hot");
        Customer customer2 = new Customer("aaaa", "Kostmann", "123456", "otto.kostmann@hot");
        customerDAO.create(customer);
        customerDAO.create(customer2);
        List<Customer> xxx = new ArrayList<Customer>();
        xxx.addAll(customerDAO.readAll());
        ObservableList<Customer> observableReviews = FXCollections.observableArrayList(xxx);
        reviewBox.setItems(observableReviews);

    }

    @FXML
    void restaurantButtonClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Customer chosenCustomer = reviewBox.getSelectionModel().getSelectedItem();
        reviewsListView.setVisible(true);
        List<Review> reviewList = new ArrayList<Review>();
        reviewList.addAll(reviewDAO.readAllFrom(reviewBox.getSelectionModel().getSelectedItem()));
        ObservableList<Review> observableReviewList = (ObservableList<Review>) FXCollections.observableArrayList(reviewList);
        reviewsListView.setItems(observableReviewList);

    }
}