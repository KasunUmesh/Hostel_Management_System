package dao.custom.impl;

import dao.custom.QueryDAO;
import dto.CustomDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfigration;

import java.time.LocalDate;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomDTO> getAll() {
        ArrayList<CustomDTO> allDetails = new ArrayList<>();
        Session session = FactoryConfigration.getInstance().getSession();;
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT r.res_ID,r.resDate,s.student_ID,s.name,rm.room_type_id,rm.room_type,r.status FROM Reservation r INNER JOIN Student s ON r.student=s.student_ID INNER JOIN Room rm ON r.room=rm.room_type_id");
        ArrayList<Object[]> details = (ArrayList<Object[]>) query.list();
        transaction.commit();
        session.close();
        for (Object[] temp:details) {
            allDetails.add(new CustomDTO(
                    (String) temp[0],
                    (LocalDate) temp[1],
                    (String) temp[2],
                    (String) temp[3],
                    (String) temp[4],
                    (String) temp[5],
                    (String) temp[6]
            ));
        }
        return allDetails;
    }
}
