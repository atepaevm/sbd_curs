package service;
import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity
@Table(name="select_galaxy")
public class Galaxy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer objectId;

    @Column(name="coords")
    @Type(type="service.CoordsUserType")
    private Coords galaxy_coords;

    @Column(name="Name")
    private String name;

    private Integer typeId;

    public Galaxy(String name, Integer typeId, Coords coords){
        this.name = name;
        this.typeId = typeId;
        this.galaxy_coords = coords;
    }

    public String getName(){
        return this.name;
    }
    public Coords getCoords(){
        return this.galaxy_coords;
    }
    public Integer getTypeId(){
        return this.typeId;
    }

    public void setGalaxy_coords(Coords galaxy_coords) {
        this.galaxy_coords = galaxy_coords;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
