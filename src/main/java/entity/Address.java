package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "address_id")
    private int addressId;
    @Basic
    @Column(name = "street_name")
    private String streetName;
    @Basic
    @Column(name = "street_number")
    private Integer streetNumber;
    @Basic
    @Column(name = "postal_number")
    private String postalNumber;
    @Basic
    @Column(name = "city")
    private String city;

    @Override
    public String toString() {
        return "ID: " + addressId +
                "\n Street name: " + streetName + '\'' +
                "\n Street number: " + streetNumber +
                "\n Postal number: " + postalNumber + '\'' +
                "\n City: " + city;
    }

    public Address() {
    }

    public Address(int addressId, String streetName, Integer streetNumber, String postalNumber, String city) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalNumber = postalNumber;
        this.city = city;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalNumber() {
        return postalNumber;
    }

    public void setPostalNumber(String postalNumber) {
        this.postalNumber = postalNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId && Objects.equals(streetName, address.streetName) && Objects.equals(streetNumber, address.streetNumber) && Objects.equals(postalNumber, address.postalNumber) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, streetName, streetNumber, postalNumber, city);
    }
}
