package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean add(Room entity) {
        return false;
    }

    @Override
    public boolean update(Room entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Room find(String s) {
        return null;
    }

    @Override
    public List<Room> findAll() {
        return null;
    }
}
