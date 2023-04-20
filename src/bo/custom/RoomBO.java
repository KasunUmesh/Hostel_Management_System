package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    boolean add(RoomDTO roomDTO);
    List<RoomDTO> findAll();
    boolean delete(String id);
    boolean update(RoomDTO roomDTO);
}
