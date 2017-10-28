package view;

import service.objectCommon.ObjectCommon;
import service.stars.Stars;

public class StarView {

    private Integer objectId;
    private String name;
    private Integer typeId;
    private Integer galaxyId;
    private Float size;
    private Float mass;
    private Float dist;

    public StarView(Stars star, ObjectCommon objectCommon){
        this.objectId = objectCommon.getObject_id();
        this.name = objectCommon.getObject_name();
        this.typeId = objectCommon.getType_id();
        this.galaxyId = star.getGalaxy_id();
        this.size = star.getStar_size();
        this.mass = star.getStar_mass();
        this.dist = star.getStar_distnace_from_sun();
    }

    @Override
    public String toString() {
        return String.format("Id: %d Name: %s Type Id: %d Galaxy Id: %d Size: %f Mass: %f Distance from sun: %f", objectId, name, typeId, galaxyId, size, mass, dist);
    }
}
