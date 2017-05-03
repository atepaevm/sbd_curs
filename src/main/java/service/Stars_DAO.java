package service;

import java.util.List;


public interface Stars_DAO {
    public void save(Stars obj);
    public void update(Stars obj);
    public void delete(Stars obj);
    public Stars read(Stars obj);
    public List<Stars> list();
}
