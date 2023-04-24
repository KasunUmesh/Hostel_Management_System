package dao.custom.impl;

import dao.custom.RoomDAO;
import dto.ReservationDTO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfigration;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean add(Room entity) {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) {

        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String s) {

        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.get(Room.class, s);
        session.delete(room);

        transaction.commit();
        return true;
    }

    @Override
    public Room find(String s) {
        return null;
    }

    @Override
    public ArrayList<Room> findAll() {

        ArrayList<Room> allRooms = new ArrayList<>();
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Room");
        allRooms = (ArrayList<Room>) query.list();

        transaction.commit();
        session.close();
        return allRooms;
    }

    @Override
    public boolean ifRoomExist(String id) throws SQLException, ClassNotFoundException{
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT room_type_id FROM Room WHERE room_type_id=:id");
        String id1 = (String) query.setParameter("id", id).uniqueResult();
        if (id1!=null) {
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException{
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT room_type_id FROM Room ORDER BY room_type_id DESC LIMIT 1");
        String s = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (s!=null) {
            int newRoomID = Integer.parseInt(s.replace("R","")) + 1;
            return String.format("R%03d", newRoomID);
        }
        return "R001";
    }

    @Override
    public Room getRoomDetails(String room_type) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Room WHERE room_type=:room_type");
        Room room = (Room) query.setParameter("room_type", room_type).uniqueResult();
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public List<String> getRoomType() throws SQLException, ClassNotFoundException {
        ArrayList<String> allRooms = new ArrayList<>();
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT room_type FROM Room");
        allRooms = (ArrayList<String>) query.list();
        transaction.commit();
        session.close();
        return allRooms;
    }

    @Override
    public BigInteger roomCount() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT COUNT(*) FROM Room");
        BigInteger bigInteger = (BigInteger) query.uniqueResult();
        transaction.commit();
        session.close();
        return bigInteger;
    }
}
