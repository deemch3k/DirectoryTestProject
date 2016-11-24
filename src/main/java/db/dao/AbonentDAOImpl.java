package db.dao;

import entities.Abonent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Дмитрий on 24.11.2016.
 */
public class AbonentDAOImpl implements AbonentDAO {

    @Override
    public Abonent select(int id) {

        String query = "SELECT * FROM abonent WHERE id = " + id;
        Abonent abonent = new Abonent();

        try{
            Statement statement = new DBWorker().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){

                abonent.setId(resultSet.getInt("id"));
                abonent.setName(resultSet.getString("name"));
                abonent.setSurname(resultSet.getString("surname"));
                abonent.setMidname(resultSet.getString("midname"));
                abonent.setAddress(resultSet.getString("adress"));
                abonent.setSkype(resultSet.getString("skype"));
                abonent.setEmail(resultSet.getString("email"));
                abonent.setNumber(resultSet.getString("number"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abonent;
    }

    @Override
    public Abonent insert(Abonent abonent) {

        String query = "INSERT INTO abonent VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = new DBWorker().getConnection().prepareStatement(query);
            preparedStatement.setString(1,abonent.getName());
            preparedStatement.setString(2,abonent.getSurname());
            preparedStatement.setString(3,abonent.getMidname());
            preparedStatement.setString(4,abonent.getAddress());
            preparedStatement.setString(5,abonent.getSkype());
            preparedStatement.setString(6,abonent.getEmail());
            preparedStatement.setString(7,abonent.getNumber());
            preparedStatement.setInt(8,abonent.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abonent;

    }

    @Override
    public boolean delete(int id) {

        String query = "DELETE FROM abonent WHERE id = " + id;
        try {
            PreparedStatement preparedStatement = new DBWorker().getConnection().prepareStatement(query);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
