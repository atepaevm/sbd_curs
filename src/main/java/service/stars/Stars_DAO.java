package service.stars;

import service.objectCommon.ObjectCommon;

import java.util.List;


public interface Stars_DAO {
    public void save(ObjectCommon objectCommon, Stars star);
    public void update(Stars obj);
    public void delete(Stars obj);
    public Stars findOne(Integer id);
    public Stars read(Stars obj);
    public List<Stars> list();
}
