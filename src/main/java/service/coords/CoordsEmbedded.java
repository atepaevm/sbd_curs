package service.coords;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CoordsEmbedded {
    @Column(name="latitude", nullable = false)
    private Float latitude;
    @Column(name="longtitude", nullable = false)
    private Float longtitude;

    public CoordsEmbedded(){}

    public CoordsEmbedded(Float longtitude, Float latitude){
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public Float getLatitude() {
        return latitude;
    }
    public Float getLongtitude() {
        return longtitude;
    }
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
    public void setLongtitude(Float longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "X: " + longtitude + " Y: " + latitude;
    }

    public String toDBString(){
        return "ROW(" + this.getLatitude() + "," + this.getLongtitude() + ")";
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
        CoordsEmbedded other = (CoordsEmbedded) obj;
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
