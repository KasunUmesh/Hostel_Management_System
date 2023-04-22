package bo.custom.impl;

import bo.custom.RoomBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dto.RoomDTO;
import entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ROOM);

    @Override
    public boolean add(RoomDTO roomDTO) throws SQLException, ClassNotFoundException {
        return roomDAO.add(new Room(
                roomDTO.getRoom_type_id(),
                roomDTO.getRoom_type(),
                roomDTO.getKey_money(),
                roomDTO.getQty()
        ));
    }

    @Override
    public ArrayList<RoomDTO> findAll() throws SQLException, ClassNotFoundException {

        List<Room> all = roomDAO.findAll();
        ArrayList<RoomDTO> roomDTOS = new ArrayList<>();
        for (Room room : all) {
            roomDTOS.add(new RoomDTO(
                    room.getRoom_type_id(),
                    room.getRoom_type(),
                    room.getKey_money(),
                    room.getQty()
            ));
        }
        return roomDTOS;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return roomDAO.delete(id);
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException {
        return roomDAO.update(new Room(
                roomDTO.getRoom_type_id(),
                roomDTO.getRoom_type(),
                roomDTO.getKey_money(),
                roomDTO.getQty()
        ));
    }
}
