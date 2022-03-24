package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurant_id")
    private int restaurantId;
    @Basic
    @Column(name = "restaurantName")
    private String restaurantName;
    @Basic
    @Column(name = "address_id")
    private Integer addressId;
    @Basic
    @Column(name = "restaurantDescription")
    private String restaurantDescription;

    public Restaurant() {
    }

    public Restaurant(int restaurantId, String restaurantName, Integer addressId, String restaurantDescription) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.addressId = addressId;
        this.restaurantDescription = restaurantDescription;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return restaurantName;
    }

    public void setName(String name) {
        this.restaurantName = restaurantName;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getDescription() {
        return restaurantDescription;
    }

    public void setDescription(String description) {
        this.restaurantDescription = restaurantDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return restaurantId == that.restaurantId && Objects.equals(restaurantName, that.restaurantName) && Objects.equals(addressId, that.addressId) && Objects.equals(restaurantDescription, that.restaurantDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, restaurantName, addressId, restaurantDescription);
    }
}
