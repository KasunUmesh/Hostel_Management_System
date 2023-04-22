package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.Room;

import java.sql.SQLException;

public interface RoomDAO extends CrudDAO<Room, String> {
    boolean ifRoomExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;

}
