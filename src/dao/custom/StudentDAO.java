package dao.custom;

import dao.SuperDAO;
import entity.Student;

import java.math.BigInteger;

public interface StudentDAO extends SuperDAO<Student, String> {
    boolean ifStudentExist(String id);
    String generateNewID();
    BigInteger studentCount();
}
