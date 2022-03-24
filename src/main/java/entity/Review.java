package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id")
    private int reviewId;
    @Basic
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "restaurant_id")
    private int restaurantId;
    @Basic
    @Column(name = "stars")
    private Integer stars;
    @Basic
    @Column(name = "reviewText")
    private String reviewText;

    @Override
    public String toString() {
        return stars +" Stars - "+ reviewText;
    }

    public Review() {
    }

    public Review(Integer stars, String text) {
        this.stars = stars;
        this.reviewText = text;
    }

    public Review(int reviewId, int customerId, int restaurantId, Integer stars, String text) {
        this.reviewId = reviewId;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.stars = stars;
        this.reviewText = text;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getText() {
        return reviewText;
    }

    public void setText(String text) {
        this.reviewText = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId && customerId == review.customerId && restaurantId == review.restaurantId && Objects.equals(stars, review.stars) && Objects.equals(reviewText, review.reviewText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, customerId, restaurantId, stars, reviewText);
    }
}
