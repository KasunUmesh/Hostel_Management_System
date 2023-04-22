package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBO extends SuperBO {
    boolean add(RoomDTO roomDTO) throws SQLException, ClassNotFoundException;
    ArrayList<RoomDTO> findAll() throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException;
}
