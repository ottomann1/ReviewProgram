package com.fyra.reviewprogram;

import com.fyra.reviewprogram.database.RestaurantDAO;
import com.fyra.reviewprogram.database.ReviewDAO;
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
    private ComboBox<?> customerDropdown;

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
    private Text restaurantNameText;

    @FXML
    private ListView<Restaurant> reviewBox;

    @FXML
    private Pane reviewPane;

    @FXML
    private TextField reviewTextField;

    @FXML
    private Text reviewsForText;

    @FXML
    private ListView<Review> reviewsListView;

    @FXML
    private CheckBox threeStar;

    @FXML
    private CheckBox twoStar;

    @FXML
    void createCustomerClick(ActionEvent event) {

    }

    @FXML
    void createReviewButtonClick(ActionEvent event) {

    }

    @FXML
    void exitCustomerCreateClick(ActionEvent event) {

    }

    @FXML
    void exitMoreInfoClick(ActionEvent event) {

    }

    @FXML
    void exitReviewClick(ActionEvent event) {

    }

    @FXML
    void moreInfoButtonClick(ActionEvent event) {

    }

    @FXML
    void submitReviewClick(ActionEvent event) {

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
        Restaurant restaurant = reviewBox.getSelectionModel().getSelectedItem();
        reviewPane.setVisible(true);
        List<Review> reviewList = new ArrayList<Review>();
        reviewList.addAll(reviewDAO.readAllFrom(reviewBox.getSelectionModel().getSelectedItem()));
        ObservableList<Review> observableReviewList = (ObservableList<Review>) FXCollections.observableArrayList(reviewList);
        reviewsListView.setItems(observableReviewList);

    }
}