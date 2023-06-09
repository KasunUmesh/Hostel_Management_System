package bo.custom;

import bo.SuperBO;
import dto.CustomDTO;
import dto.ReservationDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    boolean addReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException;
    boolean ifExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
    ArrayList<CustomDTO> getAllDetails() throws SQLException, ClassNotFoundException;
}
