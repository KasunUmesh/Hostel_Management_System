package bo.custom;

import bo.SuperBO;

import dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    boolean addStudent(StudentDTO studentDTO);
    List<StudentDTO> findAll();
    boolean delete(String id);
    boolean update(StudentDTO studentDTO);
    boolean ifStudentExist(String id);
    String generateNewID();

}
