package com.fyra.reviewprogram.database;

import entity.Restaurant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantDAO implements DAO {


    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Restaurant> restaurant = Optional.ofNullable((Restaurant) data.getData(Restaurant.class, (int) id));
        return restaurant;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> restaurantObjects = data.getDataListQuery("SELECT * FROM restaurant");
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        for (Object[] o : restaurantObjects) {
            Restaurant restaurant = new Restaurant((Integer) o[0], o[1].toString(), (Integer) o[2], o[3].toString());
            restaurants.add(restaurant);
        }
        return restaurants;
    }

    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {
        Data data = new Data();
        data.setData(o);

    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {
        Data data = new Data();
        data.updateData(newT);

    }

    @Override
    public void delete(Object o) throws IOException {
        Data data = new Data();
        Restaurant x = (Restaurant) o;
        data.deleteEm(Restaurant.class, x.getRestaurantId());

    }

    @Override
    public void deleteAll() throws IOException {

    }
}


