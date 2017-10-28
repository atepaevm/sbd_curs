package service.objectType;

import java.util.List;

public interface ObjectTypeDAO {
    public void save(ObjectType obj);
    public void update(ObjectType obj);
    public void delete(ObjectType obj);
    public ObjectType read(ObjectType obj);
    public List<ObjectType> list();
}
