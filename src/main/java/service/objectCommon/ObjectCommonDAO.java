package service.objectCommon;

import java.util.List;

public interface ObjectCommonDAO {
    public void update(ObjectCommon obj);
    public void delete(ObjectCommon obj);
    public ObjectCommon findOne(Integer id);
    public ObjectCommon read(ObjectCommon obj);
    public List<ObjectCommon> list();
}
