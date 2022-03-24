package com.fyra.reviewprogram;

import com.fyra.reviewprogram.database.Data;
import com.fyra.reviewprogram.database.RestaurantDAO;
import com.fyra.reviewprogram.database.ReviewDAO;
import entity.Restaurant;
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
    private ListView<Restaurant> reviewBox;

    @FXML
    private ListView<Review> reviewsListView;

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
        reviewsListView.setVisible(true);
        List<Review> reviewList = new ArrayList<Review>();
        reviewList.addAll(reviewDAO.readAllFrom(reviewBox.getSelectionModel().getSelectedItem()));
        ObservableList<Review> observableReviewList = (ObservableList<Review>) FXCollections.observableArrayList(reviewList);
        reviewsListView.setItems(observableReviewList);

    }
}