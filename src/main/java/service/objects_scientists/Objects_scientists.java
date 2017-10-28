package service.objects_scientists;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 12 on 28.10.2017.
 */
@Entity
@Table(name="objects_scientists")
public class Objects_scientists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="object_id")
    private Integer object_id;

    @Column(name="scientist_id")
    private Integer scientist_id;

    @Column(name="insert_timestamp")
    private Date insert_timestamp;


    public Integer getObject_id(){
        return this.object_id;
    }
    public Integer getScientist_id(){
        return this.scientist_id;
    }
    public Date getInsert_timestamp(){
        return this.insert_timestamp;
    }

    public void setObject_id(Integer id) {
       this.object_id=id;
    }
    public void setScientist_id(Integer id) {
        this.scientist_id=id;
    }
    public void setInsert_timestamp(Date id) {
        this.insert_timestamp=id;
    }
    @Override
    public String toString(){
        return "id: "+this.object_id+"sci id: "+this.scientist_id+" time: "+this.insert_timestamp;
    }
}