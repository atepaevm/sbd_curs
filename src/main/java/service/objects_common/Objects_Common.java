package service.objects_common;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="objects_common")
public class Objects_Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="object_id")
    private Integer object_id;
    @Column(name="type_id")
    private Integer type_id;
    @Column(name="object_name")
    private String object_name;
    @Column(name="added_time")
    private Date added_time;
    @Column(name="modified_by")
    private String modified_by;
    @Column(name="modified_time")
    private Date modified_time;
    @Column(name="added_by")
    private String added_by;

   // @Override
   // public String toString(){return "Name: "+this.getObject_class_name()+" id: "+this.getObject_class_id();}
}