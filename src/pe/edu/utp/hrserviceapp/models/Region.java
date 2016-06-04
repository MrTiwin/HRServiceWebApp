package pe.edu.utp.hrserviceapp.models;

/**
 * Created by GrupoUTP on 03/06/2016.
 */
public class Region {
    private int id;
    private String name;

    public Region(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
