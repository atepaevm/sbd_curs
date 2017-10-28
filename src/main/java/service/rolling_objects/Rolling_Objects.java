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
    private String orbits_around_id;
    public void setObject_id(Integer id){this.object_id=id;}
    public void setOrbits_around_id(String name){this.orbits_around_id=name;}
    public Integer getObject_id(){return object_id;}
    public String getOrbits_around_id(){return orbits_around_id;}
    @Override
    public String toString(){return "Id: "+this.getObject_id()+" orb: "+this.getOrbits_around_id();}
}