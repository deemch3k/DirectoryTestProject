package db.dao;

import entities.Abonent;

/**
 * Created by Дмитрий on 24.11.2016.
 */
public interface AbonentDAO {

    Abonent select(int id);
    Abonent insert(Abonent abonent);
    boolean delete(int id);

}
