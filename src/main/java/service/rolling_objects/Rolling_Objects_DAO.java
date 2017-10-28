package service.rolling_objects;

import java.util.List;

public interface Rolling_Objects_DAO {
    public void save(Rolling_Objects obj);
    public void update(Rolling_Objects obj);
    public void delete(Rolling_Objects obj);
    public Rolling_Objects read(Rolling_Objects obj);
    public List<Rolling_Objects> list();
}
