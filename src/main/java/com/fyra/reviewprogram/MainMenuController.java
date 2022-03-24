package com.fyra.reviewprogram;

import com.fyra.reviewprogram.database.AddressDAO;
import com.fyra.reviewprogram.database.CustomerDAO;
import com.fyra.reviewprogram.database.RestaurantDAO;
import com.fyra.reviewprogram.database.ReviewDAO;
import entity.Address;
import entity.Customer;
import entity.Restaurant;
import entity.Review;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TESTING GIT

public class MainMenuController {

    @FXML
    private Pane createCustomerPane;

    @FXML
    private Pane createReviewPane;

    @FXML
    private ComboBox<Customer> customerDropdown;

    @FXML
    private TextField emailAddressTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private CheckBox fiveStar;

    @FXML
    private CheckBox fourStar;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextArea moreInfoAddressText;

    @FXML
    private TextArea moreInfoCustomerText;

    @FXML
    private Pane moreInfoPane;

    @FXML
    private TextArea moreInfoRestaurantText;

    @FXML
    private TextArea moreInfoReviewText;

    @FXML
    private Text moreInfoText;

    @FXML
    private CheckBox oneStar;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Label restaurantNameText;

    @FXML
    private ListView<Restaurant> reviewBox;

    @FXML
    private Pane reviewPane;

    @FXML
    private TextField reviewTextField;

    @FXML
    private Label reviewsForText;

    @FXML
    private ListView<Review> reviewsListView;

    @FXML
    private CheckBox threeStar;

    @FXML
    private CheckBox twoStar;

    private Restaurant currentRestaurant;

    private Review currentReview;

    private Customer currentCustomer;
    @FXML
    void createCustomerPaneClick(ActionEvent event) {
        createCustomerPane.setVisible(true);
        createReviewPane.setVisible(false);
    }

    @FXML
    void createCustomerClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Customer customer = new Customer(firstNameTextField.getText(), lastNameTextField.getText(), phoneNumberTextField.getText(), emailAddressTextField.getText());
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.create(customer);
        createCustomerPane.setVisible(false);
        createReviewPane.setVisible(true);
        ObservableList<Customer> observableCustomers = FXCollections.observableArrayList(customerDAO.readAll());
        customerDropdown.setItems(observableCustomers);
    }


    @FXML
    void createReviewButtonClick(ActionEvent event) throws IOException, ClassNotFoundException {
        reviewPane.setVisible(false);
        restaurantNameText.setText("Write a review for "+currentRestaurant.getName());
        CustomerDAO customerDAO = new CustomerDAO();
        ObservableList<Customer> observableCustomers = FXCollections.observableArrayList(customerDAO.readAll());
        customerDropdown.setItems(observableCustomers);
        createReviewPane.setVisible(true);
    }

    @FXML
    void exitCustomerCreateClick(ActionEvent event) {
        createCustomerPane.setVisible(false);
    }

    @FXML
    void exitMoreInfoClick(ActionEvent event) {
        moreInfoPane.setVisible(false);
    }

    @FXML
    void exitReviewClick(ActionEvent event) {
        createReviewPane.setVisible(false);
        reviewPane.setVisible(false);
    }

    @FXML
    void moreInfoButtonClick(ActionEvent event) throws IOException, ClassNotFoundException {
        currentReview = reviewsListView.getSelectionModel().getSelectedItem();
        moreInfoPane.setVisible(true);
        moreInfoText.setText(currentRestaurant.getName());
        moreInfoRestaurantText.setText(currentRestaurant.toStringHeavy());
        AddressDAO addressDAO = new AddressDAO();
        Address address = (Address) addressDAO.read(currentRestaurant.getAddressId()).get();
        moreInfoAddressText.setText(address.toString());
        moreInfoReviewText.setText(currentReview.toStringHeavy());
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = (Customer) customerDAO.read(currentReview.getCustomerId()).get();
        moreInfoCustomerText.setText(customer.toStringHeavy());
    }

    @FXML
    void submitReviewClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Review review = new Review();
        if(oneStar.isSelected())
            review.setStars(1);
        if(twoStar.isSelected())
            review.setStars(2);
        if(threeStar.isSelected())
            review.setStars(3);
        if(fourStar.isSelected())
            review.setStars(4);
        if(fiveStar.isSelected())
            review.setStars(5);
        review.setText(reviewTextField.getText());
        review.setCustomerId(customerDropdown.getSelectionModel().getSelectedItem().getCustomerId());
        review.setRestaurantId(currentRestaurant.getRestaurantId());
        ReviewDAO reviewDAO = new ReviewDAO();
        reviewDAO.create(review);
        createReviewPane.setVisible(false);
        reviewPane.setVisible(true);
        List<Review> reviewList = new ArrayList<Review>();
        reviewList.addAll(reviewDAO.readAllFrom(reviewBox.getSelectionModel().getSelectedItem()));
        ObservableList<Review> observableReviewList = (ObservableList<Review>) FXCollections.observableArrayList(reviewList);
        reviewsListView.setItems(observableReviewList);
    }


    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        RestaurantDAO restaurantDAO = new RestaurantDAO();

        List<Restaurant> allRestaurants = new ArrayList<Restaurant>();
        allRestaurants.addAll(restaurantDAO.readAll());
        ObservableList<Restaurant> observableRestaurants = FXCollections.observableArrayList(allRestaurants);
        reviewBox.setItems(observableRestaurants);

    }

    @FXML
    void restaurantButtonClick(ActionEvent event) throws IOException, ClassNotFoundException {
        ReviewDAO reviewDAO = new ReviewDAO();
        currentRestaurant = reviewBox.getSelectionModel().getSelectedItem();
        reviewsForText.setText("Reviews for "+reviewBox.getSelectionModel().getSelectedItem().getName());
        reviewPane.setVisible(true);
        createReviewPane.setVisible(false);
        createCustomerPane.setVisible(false);
        moreInfoPane.setVisible(false);
        List<Review> reviewList = new ArrayList<Review>();
        reviewList.addAll(reviewDAO.readAllFrom(reviewBox.getSelectionModel().getSelectedItem()));
        ObservableList<Review> observableReviewList = (ObservableList<Review>) FXCollections.observableArrayList(reviewList);
        reviewsListView.setItems(observableReviewList);

    }
}