package service.galaxies;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import service.coords.Coords;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Cache(region="common", usage = CacheConcurrencyStrategy.READ_WRITE)  // or @Cacheable(true) for JPA
@Table(name="galaxies")
public class Galaxies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="object_id")
    private Integer object_id;
    @Column(name="galaxy_coordinates")
    @Type(type="service.coords.CoordsUserType")
    private Coords galaxy_coordinates;
    public Galaxies(){};
    public Galaxies(Coords coords){
        this.galaxy_coordinates = coords;
    }
    public Integer getObject_id(){
        return this.object_id;
    }
    public Coords getCoords(){
        return this.galaxy_coordinates;
    }


    public void setGalaxy_coordinates(Coords coords) {
        this.galaxy_coordinates = coords;
    }
    public void setObject_id(Integer id) {
        this.object_id=id;
    }
@Override
public String toString(){
        return "id: "+this.object_id+" Coords: "+this.galaxy_coordinates;
    }
}
