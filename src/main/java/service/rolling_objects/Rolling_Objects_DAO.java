package service.rolling_objects;

import service.objectCommon.ObjectCommon;

import java.util.List;

public interface Rolling_Objects_DAO {
    public void save(ObjectCommon objectCommon, Rolling_Objects obj);
    public void update(Rolling_Objects obj);
    public void delete(Rolling_Objects obj);
    public Rolling_Objects read(Rolling_Objects obj);
    public List<Rolling_Objects> list();
}
