package dao.custom.impl;

import dao.custom.StudentDAO;
import dto.ReservationDTO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfigration;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws SQLException, ClassNotFoundException{
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException{
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, s);
        session.delete(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student find(String s) throws SQLException, ClassNotFoundException{
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, s);
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public ArrayList<Student> findAll() throws SQLException, ClassNotFoundException{
        ArrayList<Student> allStudent = new ArrayList<>();
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Student");
        allStudent = (ArrayList<Student>) query.list();

        transaction.commit();
        session.close();
        return allStudent;
    }

    @Override
    public boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException{
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT student_ID FROM Student WHERE student_ID=:id");
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
        Query query = session.createSQLQuery("SELECT student_ID FROM Student ORDER BY student_ID DESC LIMIT 1");
        String s = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (s!=null) {
            int newStudentID = Integer.parseInt(s.replace("S", "")) + 1;
            return String.format("S%03d", newStudentID);
        }
        return "S001";
    }

    @Override
    public BigInteger studentCount() throws SQLException, ClassNotFoundException{
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT COUNT(*) FROM Student");
        BigInteger bigInteger = (BigInteger) query.uniqueResult();
        transaction.commit();
        session.close();
        return bigInteger;
    }

    @Override
    public List<String> getStudentID() throws SQLException, ClassNotFoundException {
        ArrayList<String> allStudent = new ArrayList<>();
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT student_ID FROM Student");
        allStudent = (ArrayList<String>) query.list();
        transaction.commit();
        session.close();
        return allStudent;
    }

    @Override
    public String getStudentName(String id) throws SQLException, ClassNotFoundException {
       Session session = FactoryConfigration.getInstance().getSession();
       Transaction transaction = session.beginTransaction();
       Query query = session.createQuery("SELECT name FROM Student WHERE student_ID=:id");
       String id1 = (String) query.setParameter("id", id).uniqueResult();
       if (id1!=null) {
           return id1;
       }
       transaction.commit();
       session.close();
       return null;
    }
}
