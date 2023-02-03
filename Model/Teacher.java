package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher {

    private IntegerProperty tid = new SimpleIntegerProperty();
    private StringProperty tnum = new SimpleStringProperty();
    private StringProperty tname = new SimpleStringProperty();

    public Teacher(int tid,String tnum, String tname) {
        this.setTid(tid);
        this.setTnum(tnum);
        this.setTname(tname);
    }

    public int getTid() {
        return tid.get();
    }
    public String getTnum() {
        return tnum.get();
    }

    public String getTname() {
        return tname.get();
    }

    public void setTid(int tid) {
        this.tid.set(tid);
    }

    public void setTnum(String tnum) {
        this.tnum.set(tnum);
    }

    public void setTname(String tname) {
        this.tname.set(tname);
    }

}
