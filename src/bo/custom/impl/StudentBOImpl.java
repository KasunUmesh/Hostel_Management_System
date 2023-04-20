package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public boolean addStudent(StudentDTO studentDTO) {
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
    public List<StudentDTO> findAll() {
        List<Student> all = studentDAO.findAll();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
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
    public boolean delete(String id) {
        return studentDAO.delete(id);
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
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
    public boolean ifStudentExist(String id) {
        return studentDAO.ifStudentExist(id);
    }

    @Override
    public String generateNewID() {
        return studentDAO.generateNewID();
    }
}
