package service.objects_scientists;

import java.util.List;

public interface Objects_Scientists_DAO {
    public void save(Objects_scientists obj);
    public void update(Objects_scientists obj);
    public void delete(Objects_scientists obj);
    public Objects_scientists read(Objects_scientists obj);
    public List<Objects_scientists> list();
}
