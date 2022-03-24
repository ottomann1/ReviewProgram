package com.fyra.reviewprogram.database;

import entity.Customer;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAO implements DAO {

    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Customer> x = Optional.ofNullable((Customer) data.getData(Customer.class, (int) id));
        return x;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> customerObjects = data.getDataListQuery("SELECT * FROM customer");
        List<Customer> customers = new ArrayList<Customer>();
        for (Object[] o : customerObjects) {
        Customer customer = new Customer(o[1].toString(), o[2].toString(), o[3].toString(), o[4].toString());
        customer.setCustomerId((Integer) o[0]);
        customers.add(customer);
    }
        return customers;
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
    Customer customer = (Customer) o;
    data.deleteEm(Customer.class, customer.getCustomerId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
