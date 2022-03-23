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
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "address_id")
    private Integer addressId;
    @Basic
    @Column(name = "description")
    private String description;

    public Restaurant() {
    }

    public Restaurant(int restaurantId, String name, Integer addressId, String description) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.addressId = addressId;
        this.description = description;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return restaurantId == that.restaurantId && Objects.equals(name, that.name) && Objects.equals(addressId, that.addressId) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, name, addressId, description);
    }
}
