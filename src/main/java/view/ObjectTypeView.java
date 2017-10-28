package view;

import service.objectClass.ObjectClass;
import service.objectType.ObjectType;

public class ObjectTypeView {
    private Integer id;
    private Integer classId;
    private String className;
    private String typeName;

    public ObjectTypeView(ObjectClass objectClass, ObjectType type){
        this.id = type.getObject_type_id();
        this.classId = objectClass.getObject_class_id();
        this.className = objectClass.getObject_class_name();
        this.typeName = type.getObject_type_name();
    }

    @Override
    public String toString() {
        return "Id: " + id + " Class Id: " + classId + " Class Name: " + className + " Type Name: " + typeName;
    }
}