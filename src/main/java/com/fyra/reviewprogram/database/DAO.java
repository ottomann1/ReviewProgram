package com.fyra.reviewprogram.database;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> read(long id) throws IOException, ClassNotFoundException;
//    Data data = new Data();
//    Optional<T> x = Optional.ofNullable((T) data.getData(T.class, (int) id));
//    return x;

    List<T> readAll() throws IOException, ClassNotFoundException;
//    Data data = new Data();
//    List<Object[]> customerObjects = data.getDataListQuery("SELECT * FROM x");
//    List<X> xs = new ArrayList<X>();
//        for (Object[] o : xObjects) {
//        System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3] + " " + o[4] + " " + o[5] + " ");
//        X x = new X(o[1].toString(), o[2].toString(), (Date) o[3], o[4].toString());
//        x.setXId((Integer) o[0]);
//        xs.add(x);
//        System.out.println(x + " ADDED");
//    }
//        return xs;

    void create(T t) throws IOException, ClassNotFoundException;
//     Data data = new Data();
//     data.setData(o);

    void update(T newT, T oldT) throws IOException;
//    Data data = new Data();
//        data.updateData(newT);

    void delete(T t) throws IOException;
//    Data data = new Data();
//    X x = (Address) o;
//        data.deleteEm(X.class, x.getXId());

    void deleteAll() throws IOException;
}
