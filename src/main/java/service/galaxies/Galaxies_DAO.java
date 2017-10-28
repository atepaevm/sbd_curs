package service.galaxies;
import java.util.List;

public interface Galaxies_DAO {
    public void save(Galaxies obj);
    public void update(Galaxies obj);
    public void delete(Galaxies obj);
    public Galaxies read(Galaxies obj);
    public List<Galaxies> list();
}
