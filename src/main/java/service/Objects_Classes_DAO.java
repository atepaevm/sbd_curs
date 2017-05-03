package service;

import java.util.List;

public interface Objects_Classes_DAO {
    public void save(Objects_Classes obj);
    public void update(Objects_Classes obj);
    public void delete(Objects_Classes obj);
    public Objects_Classes read(Objects_Classes obj);
    public List<Objects_Classes> list();
}
