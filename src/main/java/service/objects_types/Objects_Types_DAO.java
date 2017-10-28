package service.objects_types;

import service.Objects_Classes.Objects_Classes;

import java.util.List;

public interface Objects_Types_DAO {
    public void save(Objects_types obj);
    public void update(Objects_types obj);
    public void delete(Objects_types obj);
    public Objects_types read(Objects_types obj);
    public List<Objects_types> list();
}
