package service.coords;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;
import java.util.StringTokenizer;

public class CoordsUserType implements UserType {

    protected static final int[] SQL_TYPES = {Types.JAVA_OBJECT};

    public int[] sqlTypes() {
        return CoordsUserType.SQL_TYPES;
    }

    public Class returnedClass() {
        return Coords.class;
    }

    public boolean equals(Object o, Object o1) throws HibernateException {
        return false;
    }

    public int hashCode(Object o) throws HibernateException {
        return 0;
    }

    public Object nullSafeGet(ResultSet resultSet, String[] strings, Object o) throws HibernateException, SQLException {
        String val = resultSet.getString(strings[0]);
        StringTokenizer tokenizer = new StringTokenizer(val.substring(1, val.length() -1), ",");
        return new Coords(Float.parseFloat(tokenizer.nextToken()), Float.parseFloat(tokenizer.nextToken()));
    }

    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i) throws HibernateException, SQLException {
        Coords obj = (Coords)o;
        //preparedStatement.setObject(obj);
        //preparedStatement=con.prepareStatement("(?,?)");
       preparedStatement.setObject(i,"("+obj.getLatitude()+","+obj.getLongtitude() + ")");
        //preparedStatement.setString(i, "(" + obj.getLatitude() + " , " + obj.getLongtitude() + ")" );
    }

    public Object deepCopy(Object o) throws HibernateException {
        Coords coordinates = (Coords)o;
        return new Coords(coordinates.getLatitude(), coordinates.getLongtitude());
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }
}
