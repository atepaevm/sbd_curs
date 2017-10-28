package service.galaxies;
import service.objectCommon.ObjectCommon;

import java.util.List;

public interface Galaxies_DAO {
    public void save(ObjectCommon objectCommon, Galaxies galaxy);
    public void update(Galaxies obj);
    public void delete(Galaxies obj);
    public Galaxies read(Galaxies obj);
    public List<Galaxies> list();
}
