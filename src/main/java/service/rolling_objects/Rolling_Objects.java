package service.rolling_objects;
import javax.persistence.*;

@Entity
@Table(name="rolling_objects")
public class Rolling_Objects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="object_id")
    private Integer object_id;
    @Column(name="orbits_around_id")
    private Integer orbits_around_id;
    public Rolling_Objects(){};
    public Rolling_Objects(Integer orbitsAround){
        this.orbits_around_id = orbitsAround;
    }

    public void setObject_id(Integer id){this.object_id=id;}
    public void setOrbits_around_id(Integer orbitsAround){this.orbits_around_id=orbitsAround;}
    public Integer getObject_id(){return object_id;}
    public Integer getOrbits_around_id(){return orbits_around_id;}
    @Override
    public String toString(){return "Id: "+this.getObject_id()+" orb: "+this.getOrbits_around_id();}
}