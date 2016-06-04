package pe.edu.utp.hrserviceapp.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by GrupoUTP on 03/06/2016.
 */
//Conecta las entidades con la misma conexion
public class HRService {
    private RegionsEntity regionsEntity;
    Connection connection;
    DataSource dataSource;
    private static String DATA_SOURCE = "jdbc/MySQLDataSource";

    public HRService(InitialContext context){
        try {
            dataSource = (DataSource) context.lookup(DATA_SOURCE);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    //Obtiene una nueva conexion
    public boolean connect(){
        if(connection == null){
            try {
                connection = dataSource.getConnection();
                return(connection !=null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public Connection getConnection(){
        if(connection == null){
            if (!connect()){
                return null;
            };
        }
        return connection;
    }

    //Para toda entidad solo se maneje una conexion
    //Quien solicite la conexion va a usar la misma conexion
    public RegionsEntity getRegionsEntity() {
        if(regionsEntity==null){
            regionsEntity = new RegionsEntity();
            regionsEntity.setConnection(getConnection());
        }
        return regionsEntity;
    }

    public void setRegionsEntity(RegionsEntity regionsEntity) {
        this.regionsEntity = regionsEntity;
    }
}
