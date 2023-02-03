package sample.Model;

import javafx.beans.property.*;

public class Room {

    private final IntegerProperty rid = new SimpleIntegerProperty();
    private final StringProperty rname = new SimpleStringProperty();
    private final IntegerProperty capacity = new SimpleIntegerProperty();

    public Room(int rid,String rname,int capacity) {
        this.capacity.set(capacity);
        this.rid.set(rid);
        this.rname.set(rname);

    }

    public int getRid() {
        return rid.get();
    }

    public void setRid(int rid) {
        this.rid.set(rid);
    }

    public String getRname() {
        return rname.get();
    }


    public void setRname(String rname) {
        this.rname.set(rname);
    }

    public Integer getCapacity() {
        return capacity.get();
    }

    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }
}
