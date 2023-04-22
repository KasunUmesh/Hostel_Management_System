package dao.custom.impl;

import dao.custom.ReservationDAO;
import dto.ReservationDTO;
import entity.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfigration;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean add(Reservation reservation) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(reservation);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation reservation) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Reservation find(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Reservation> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Reservation> allReservation = new ArrayList<>();
        Session session =FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Reservation");
        allReservation = (ArrayList<Reservation>) query.list();
        transaction.commit();
        session.close();
        return allReservation;
    }
    @Override
    public ArrayList<ReservationDTO> getAllReservation() throws SQLException, ClassNotFoundException {
      /* ArrayList<ReservationDTO> allReservation = new ArrayList<>();
       Session session =FactoryConfigration.getInstance().getSession();
       Transaction transaction = session.beginTransaction();
       Query query = session.createQuery("FROM Reservation");
       allReservation = (ArrayList<ReservationDTO>) query.list();
       transaction.commit();
       session.close();
       return allReservation;*/
        return null;
    }

    @Override
    public boolean ifResExist(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT res_ID FROM Reservation WHERE res_ID=:id");
        String id1 = (String) query.setParameter("id", id).uniqueResult();
        if (id1!=null) {
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT res_ID FROM Reservation ORDER BY res_ID DESC LIMIT 1");
        String s = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (s!=null) {
            int newResID = Integer.parseInt(s.replace("RS", "")) + 1;
            return String.format("RS%03d", newResID);
        }
        return "RS001";
    }


}
