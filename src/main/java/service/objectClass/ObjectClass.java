package service.objectClass;
import javax.persistence.*;
@Entity
@Table(name="objects_classes")
public class ObjectClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="object_class_id")
    private Integer object_class_id;
    @Column(name="object_class_name")
    private String object_class_name;
    public ObjectClass(String name){
        this.object_class_name = name;
    }
    public ObjectClass(){}
    public void setObject_class_id(Integer id){this.object_class_id=id;}
    public void setObject_class_name(String name){this.object_class_name=name;}
    public Integer getObject_class_id(){return object_class_id;}
    public String getObject_class_name(){return object_class_name;}
    @Override
    public String toString(){return "Name: "+this.getObject_class_name()+" id: "+this.getObject_class_id();}
}