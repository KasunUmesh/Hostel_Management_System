package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public boolean addStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException {
        return studentDAO.add(new Student(
                studentDTO.getStudent_ID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact_no(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }

    @Override
    public ArrayList<StudentDTO> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
        ArrayList<Student> all = studentDAO.findAll();
        for (Student student : all) {
            studentDTOS.add(new StudentDTO(
                    student.getStudent_ID(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact_no(),
                    student.getDob(),
                    student.getGender()
            ));
        }
        return studentDTOS;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.delete(id);
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws SQLException, ClassNotFoundException {
        return studentDAO.update(new Student(
                studentDTO.getStudent_ID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact_no(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.ifStudentExist(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return studentDAO.generateNewID();
    }
}
