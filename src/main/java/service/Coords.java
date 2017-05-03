package service;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by 12 on 24.10.2017.
 */
@Embeddable
public class Coords{
    @Column(name="latitude")
    private Float latitude;
    @Column(name="longtitude")
    private Float longtitude;
    public Coords(Float latitude,Float longtitude){
        this.latitude=latitude;
        this.longtitude=longtitude;
    }
    public Coords(){}
    public Float getLatitude(){return latitude;}
    public Float getLongtitude(){return longtitude;}
    public void setLatitude(Float latitude){this.latitude=latitude;}
    public void setLongtitude(Float longtitude){this.longtitude=longtitude;}
    @Override
    public String toString(){
        return "X: "+latitude.toString()+"Y: "+longtitude.toString();
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longtitude == null) ? 0 : longtitude.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coords other = (Coords) obj;
        if (latitude == null) {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        if (longtitude == null) {
            if (other.longtitude!= null)
                return false;
        } else if (!longtitude.equals(other.longtitude))
            return false;
        return true;
    }
}
