package bo.custom.impl;

import bo.custom.RoomBO;
import dto.RoomDTO;

import java.util.List;

public class RoomBOImpl implements RoomBO {
    @Override
    public boolean add(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public List<RoomDTO> findAll() {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(RoomDTO roomDTO) {
        return false;
    }
}
