package bo.custom.impl;

import bo.custom.RoomBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dao.custom.impl.RoomDAOImpl;
import dto.RoomDTO;
import entity.Room;

import java.util.List;

public class RoomBOImpl implements RoomBO {

    private final RoomDAO roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOM);

    @Override
    public boolean add(RoomDTO roomDTO) {
        return roomDAO.add(new Room(
                roomDTO.getRoom_type_id(),
                roomDTO.getRoom_type(),
                roomDTO.getKey_money(),
                roomDTO.getQty()
        ));
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
