package service.galaxies;
import service.coords.CoordsEmbedded;

import javax.persistence.*;

@Entity
@Table(name="galaxies")
public class Galaxies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="object_id")
    private Integer object_id;

    @Column(name="galaxy_coordinates")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="latitude", column = @Column(name="galaxy_coordinates.latitude")),
            @AttributeOverride(name="longtitude", column = @Column(name="galaxy_coordinates.longtitude"))
    })
    private CoordsEmbedded galaxy_coordinates;
    public Galaxies(){};
    public Galaxies(CoordsEmbedded coords){
        this.galaxy_coordinates = coords;
    }
    public Integer getObject_id(){
        return this.object_id;
    }
    public CoordsEmbedded getCoords(){
        return this.galaxy_coordinates;
    }


    public void setGalaxy_coordinates(CoordsEmbedded coords) {
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
