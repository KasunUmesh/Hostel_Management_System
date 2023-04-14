package dao;

import entity.SuperEntity;

import java.util.List;

public interface SuperDAO <Entity extends SuperEntity, ID>{

    public boolean add(Entity entity);
    public boolean update(Entity entity);
    public boolean delete(ID id);
    public Entity find(ID id);
    public List<Entity> findAll();
}
