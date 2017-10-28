package service.stars;
import service.coords.CoordsEmbedded;

import javax.persistence.*;

@Entity
@Table(name="stars")
public class Stars {
    @Id
    @Column(name="object_id")
    private Integer object_id;
    @Column(name="galaxy_id")
    private Integer galaxy_id;
    @Column(name="star_coordinates")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="latitude", column = @Column(name="star_coordinates.latitude")),
            @AttributeOverride(name="longtitude", column = @Column(name="star_coordinates.longtitude"))
    })
    private CoordsEmbedded star_coodinates;
    @Column(name="star_size")
    private Float star_size;
    @Column(name="star_mass")
    private Float star_mass;
    @Column(name="star_distance_from_sun")
    private Float star_distnace_from_sun;

    public Stars(){};
    public Stars(Integer galaxyId, CoordsEmbedded starCoords, Float starSize, Float starMass, Float starDist){
        this.galaxy_id = galaxyId;
        this.star_coodinates = starCoords;
        this.star_size = starSize;
        this.star_mass = starMass;
        this.star_distnace_from_sun = starDist;
    }

    public void setObject_id(Integer id){this.object_id=id;}
    public void setGalaxy_id(Integer id){this.galaxy_id=id;}
    public void setStar_coodinates(CoordsEmbedded id){this.star_coodinates=id;}
    public void setStar_size(Float id){this.star_size=id;}
    public void setStar_mass(Float id){this.star_mass=id;}
    public void setStar_distnace_from_sun(Float id){this.star_distnace_from_sun=id;}

    public Integer getObject_id(){return object_id;}
    public Integer getGalaxy_id(){return galaxy_id;}
    public CoordsEmbedded getStar_coodinates(){
        return star_coodinates;
    }
    public Float getStar_size(){return star_size;}
    public Float getStar_mass(){return star_mass;}
    public Float getStar_distnace_from_sun(){return star_distnace_from_sun;}

    @Override
    public String toString(){return "id: "+this.getObject_id()+" galaxy id: "+this.getGalaxy_id()+
            " Coords: "+this.getStar_coodinates()+" Size: "+this.getStar_size()+" Mass: "+this.getStar_mass()+
            " Distance: "+this.getStar_distnace_from_sun();}
}
