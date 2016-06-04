package pe.edu.utp.hrserviceapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrupoUTP on 03/06/2016.
 */
//Encapsula el acceso a la tabla interactuando con solo objetos
public class RegionsEntity {
    private Connection connection;
    private static String DEFAULT_QUERY = "Select * From regions";

    public List<Region> findAll(){
        String query = DEFAULT_QUERY;
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(query);
            if(rs==null){
                return null;
            }
            List<Region> regions = new ArrayList<>();
            while(rs.next()){
                Region region = new Region(
                        rs.getInt("region_id"),
                        rs.getString("region_name")
                );
                regions.add(region);
            }
            return regions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Region findById(int id){
        String query = DEFAULT_QUERY + " where region_id= "+Integer.toString(id);
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(query);
            if(rs==null){
                return null;
            }
            if(rs.next()){
                Region region = new Region(
                        rs.getInt("region_id"),
                        rs.getString("region_name")
                );
                return region;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Region findByName(String name){
        String query = DEFAULT_QUERY + " where region_name = " + "'" + name + "'";
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(query);
            if(rs==null){
                return null;
            }
            if(rs.next()){
                Region region = new Region(
                        rs.getInt("region_id"),
                        rs.getString("region_name")
                );
                return region;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
