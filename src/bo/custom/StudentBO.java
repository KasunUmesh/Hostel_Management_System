package bo.custom;

import bo.SuperBO;

import dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO {
    boolean addStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException;
    ArrayList<StudentDTO> findAll() throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean update(StudentDTO studentDTO) throws SQLException, ClassNotFoundException;
    boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;

}
