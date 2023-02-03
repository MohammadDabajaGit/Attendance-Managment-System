package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CourseRegistration {
    private IntegerProperty sid = new SimpleIntegerProperty();
    private StringProperty snum = new SimpleStringProperty();
    private StringProperty sname = new SimpleStringProperty();
    private StringProperty cid = new SimpleStringProperty();
    private StringProperty cnum = new SimpleStringProperty();
    private StringProperty cname = new SimpleStringProperty();

    public CourseRegistration(int sid,String snum, String sname,String cid, String cnum, String cname) {
        this.setSid(sid);
        this.setSnum(snum);
        this.setSname(sname);
        this.setCid(cid);
        this.setCnum(cnum);
        this.setCname(cname);
    }

    public int getSid() {
        return sid.get();
    }

    public void setSid(int sid) {
        this.sid.set(sid);
    }

    public String getSnum() {
        return snum.get();
    }

    public void setSnum(String snum) {
        this.snum.set(snum);
    }

    public String getSname() {
        return sname.get();
    }

    public void setSname(String sname) {
        this.sname.set(sname);
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