package dao;

import dto.ReservationDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T, ID> extends SuperDAO{
    boolean add(T t) throws SQLException, ClassNotFoundException;
    boolean update(T t) throws SQLException, ClassNotFoundException;
    boolean delete(ID id) throws SQLException, ClassNotFoundException;
    T find(ID id) throws SQLException, ClassNotFoundException;
    ArrayList<T> findAll() throws SQLException, ClassNotFoundException;
}
