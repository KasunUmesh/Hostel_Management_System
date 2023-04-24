package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.Room;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room, String> {
    boolean ifRoomExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
    Room getRoomDetails(String room_type) throws SQLException, ClassNotFoundException;
    List<String> getRoomType() throws SQLException, ClassNotFoundException;
    BigInteger roomCount() throws SQLException, ClassNotFoundException;

}
