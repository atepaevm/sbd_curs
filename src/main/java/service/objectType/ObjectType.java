package service.objectType;

import javax.persistence.*;

/**
 * Created by 12 on 28.10.2017.
 */
@Entity
@Table(name="Objects_Types")
public class ObjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="object_class_id")
    private Integer object_class_id;

    @Column(name="object_type_id")
    private Integer object_type_id;
    @Column(name="object_type_name")
    private String object_type_name;

    public Integer getObject_class_id(){
        return this.object_class_id;
    }
    public String getObject_type_name(){
        return this.object_type_name;
    }
    public Integer getObject_type_id(){
        return this.object_type_id;
    }

    public void setObject_class_id(Integer id) {
       this.object_class_id=id;
    }
    public void setObject_type_id(Integer id) {
        this.object_type_id=id;
    }
    public void setObject_type_name(String id) {
        this.object_type_name=id;
    }
    @Override
    public String toString(){
        return "Class id: "+this.object_class_id+" type id: "+this.object_type_id+" type name: "+this.object_type_name;
    }
}