package dao.custom;

import dao.CrudDAO;
import entity.Reservation;

import java.sql.SQLException;

public interface ReservationDAO extends CrudDAO<Reservation, String> {
    boolean ifResExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
}
