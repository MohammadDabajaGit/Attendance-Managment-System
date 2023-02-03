package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.security.SignatureSpi;

public class TeachersCourse {
    private final IntegerProperty tid = new SimpleIntegerProperty();
    private final StringProperty tnum = new SimpleStringProperty();
    private final StringProperty tname = new SimpleStringProperty();
    private final StringProperty cid = new SimpleStringProperty();
    private final StringProperty cnum = new SimpleStringProperty();
    private final StringProperty cname = new SimpleStringProperty();

    public TeachersCourse(int tid,String tnum, String tname, String cid,String cnum, String cname) {
        this.setTid(tid);
        this.setTnum(tnum);
        this.setTname(tname);
        this.setCid(cid);
        this.setCnum(cnum);
        this.setCname(cname);
    }

    public int getTid() {
        return tid.get();
    }

    public void setTid(int tid) {
        this.tid.set(tid);
    }

    public String getTnum() {
        return tnum.get();
    }

    public void setTnum(String tnum) {
        this.tnum.set(tnum);
    }

    public String getTname() {
        return tname.get();
    }

    public void setTname(String tname) {
        this.tname.set(tname);
    }

    public String getCid() {
        return cid.get();
    }

    public void setCid(String cid) {
        this.cid.set(cid);
    }

    public String getCnum() {
        return cnum.get();
    }

    public void setCnum(String cnum) {
        this.cnum.set(cnum);
    }

    public String getCname() {
        return cname.get();
    }

    public void setCname(String cname) {
        this.cname.set(cname);
    }
}
