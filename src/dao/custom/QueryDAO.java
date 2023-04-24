package dao.custom;

import dao.SuperDAO;
import dto.CustomDTO;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomDTO> getAll();
}
