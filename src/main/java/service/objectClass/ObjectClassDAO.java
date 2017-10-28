package service.objectClass;

import java.util.List;

public interface ObjectClassDAO {
    public void save(ObjectClass obj);
    public void update(ObjectClass obj);
    public void delete(ObjectClass obj);
    public ObjectClass read(ObjectClass obj);
    public ObjectClass findOne(Integer id);
    public List<ObjectClass> list();
}
