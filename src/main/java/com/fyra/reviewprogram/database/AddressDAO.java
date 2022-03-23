package com.fyra.reviewprogram.database;

import entity.Address;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressDAO implements DAO{

    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
            Data data = new Data();
    Optional<Address> x = Optional.ofNullable((Address) data.getData(Address.class, (int) id));
    return x;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
            Data data = new Data();
    List<Object[]> xObjects = data.getDataListQuery("SELECT * FROM address");
    List<Address> xs = new ArrayList<Address>();
        for (Object[] o : xObjects) {
        System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3] + " " + o[4] + " " + o[5] + " ");
        Address x = new Address((Integer) o[0], o[1].toString(), (Integer) o[2], o[3].toString(), o[4].toString());
        xs.add(x);
        System.out.println(x + " ADDED");
    }
        return xs;
    }

    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {

    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {

    }

    @Override
    public void delete(Object o) throws IOException {

    }

    @Override
    public void deleteAll() throws IOException {

    }
}
