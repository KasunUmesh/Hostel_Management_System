package dao.custom;

import dao.CrudDAO;
import dto.ReservationDTO;
import entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationDAO extends CrudDAO<Reservation, String> {
    boolean ifResExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
    ArrayList<ReservationDTO> getAllReservation() throws SQLException, ClassNotFoundException;
}
