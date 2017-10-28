package service.objects_common;

import java.util.List;

public interface Objects_Common_DAO {
    public void save(Objects_Common obj);
    public void update(Objects_Common obj);
    public void delete(Objects_Common obj);
    public Objects_Common read(Objects_Common obj);
    public List<Objects_Common> list();
}
