package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.security.SignatureSpi;
import java.sql.Timestamp;

public class Session {

    private IntegerProperty sid = new SimpleIntegerProperty();
    private StringProperty sname = new SimpleStringProperty();
    private StringProperty cid = new SimpleStringProperty();
    private StringProperty cnum = new SimpleStringProperty();
    private StringProperty cname = new SimpleStringProperty();
    private IntegerProperty tid = new SimpleIntegerProperty();
    private StringProperty tnum = new SimpleStringProperty();
    private StringProperty tname = new SimpleStringProperty();
    private IntegerProperty rid = new SimpleIntegerProperty();
    private StringProperty rname = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private Timestamp beginTime;

    public Session(int sid, String sname, String cid,String cnum, String cname,int tid,String tnum, String tname,int rid,String rname, String description,Timestamp beginTime) {
        this.setSid(sid);
        this.setSname(sname);
        this.setCid(cid);
        this.setCnum(cnum);
        this.setCname(cname);
        this.setTid(tid);
        this.setTnum(tnum);
        this.setTname(tname);
        this.setRid(rid);
        this.setRname(rname);
        this.setDescription(description);
        this.setBeginTime(beginTime);
    }

    public int getSid() {
        return sid.get();
    }

    public void setSid(int sid) {
        this.sid.set(sid);
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

    public Integer getRid() {
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


    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }
}