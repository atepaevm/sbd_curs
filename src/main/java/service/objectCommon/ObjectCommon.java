package service.objectCommon;
import javax.persistence.*;

@Entity
@Table(name="Objects_Common")
public class ObjectCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="object_id")
    private Integer object_id;
    @Column(name="type_id")
    private Integer type_id;
    @Column(name="object_name")
    private String object_name;

    public ObjectCommon(){}
    public ObjectCommon(String name, Integer type){
        this.type_id = type;
        this.object_name = name;
    }

    public Integer getObject_id() {
        return object_id;
    }
    public Integer getType_id() {
        return type_id;
    }
    public String getObject_name() {
        return object_name;
    }
    public void setObject_id(Integer object_id) {
        this.object_id = object_id;
    }
    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }
    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    @Override
   public String toString(){return "Name: "+ object_name +" id: "+ object_id;}
}