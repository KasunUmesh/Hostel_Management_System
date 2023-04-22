package bo.custom.impl;

import bo.custom.ReservationBO;
import dao.DAOFactory;
import dao.custom.ReservationDAO;
import dto.ReservationDTO;
import entity.Reservation;
import entity.Room;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfigration;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {

    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.RESERVATION);

    @Override
    public boolean addReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, dto.getStudentID());
        Room room = session.get(Room.class, dto.getRoomID());

        Reservation reservation = new Reservation(dto.getRes_ID(), dto.getResDate(), student, room, dto.getStatus());
        session.save(reservation);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean ifExist(String id) throws SQLException, ClassNotFoundException {
        return reservationDAO.ifResExist(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return reservationDAO.generateNewID();
    }

    @Override
    public ArrayList<ReservationDTO> getAllDetails() throws SQLException, ClassNotFoundException {
        ArrayList<ReservationDTO> allDetails = new ArrayList<>();
        ArrayList<Reservation> all = reservationDAO.findAll();
        for (ReservationDTO dto : all) {
            allDetails.add(new ReservationDTO(
                    dto.getRes_ID(),
                    dto.getResDate(),
                    dto.getStudentID(),
                    dto.getRoomID(),
                    dto.getStatus()
                    ));
        }
        return allDetails;
    }
}
