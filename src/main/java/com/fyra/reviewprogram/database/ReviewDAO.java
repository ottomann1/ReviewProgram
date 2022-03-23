package com.fyra.reviewprogram.database;

import entity.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewDAO implements DAO{
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Review> review = Optional.ofNullable((Review) data.getData(Review.class, (int) id));
        return review;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
            Data data = new Data();
    List<Object[]> reviewObjects = data.getDataListQuery("SELECT * FROM review");
    List<Review> reviews = new ArrayList<Review>();
        for (Object[] o : reviewObjects) {
        Review review = new Review((Integer) o[0], (Integer) o[1], (Integer) o[2], (Integer) o[3], o[4].toString());
        reviews.add(review);
    }
        return reviews;
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
    Review x = (Review) o;
        data.deleteEm(Review.class, x.getReviewId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
