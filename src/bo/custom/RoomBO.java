package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    public boolean add(RoomDTO roomDTO);
    public List<RoomDTO> findAll();
    public boolean delete(String id);
    public boolean update(RoomDTO roomDTO);
}
