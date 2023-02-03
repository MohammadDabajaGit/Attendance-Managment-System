package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Timestamp;

public class Attendence {
    private final IntegerProperty attId = new SimpleIntegerProperty();
    private final IntegerProperty attenderId = new SimpleIntegerProperty();
    private final StringProperty attenderNum = new SimpleStringProperty();
    private final StringProperty attenderName = new SimpleStringProperty();
    private final IntegerProperty sid = new SimpleIntegerProperty();
    private final StringProperty sname = new SimpleStringProperty();
    private final IntegerProperty cid = new SimpleIntegerProperty();
    private final StringProperty cnum = new SimpleStringProperty();
    private StringProperty cname = new SimpleStringProperty();
    private Timestamp attended_From;
    private Timestamp attended_To;
    private Timestamp beginTime;

    public Attendence(int attId, int attenderId,String attenderNum, String attenderName, int sid, String sname,int cid,String cnum, String cname, Timestamp attended_From, Timestamp attended_To, Timestamp beginTime) {
        this.setAttId(attId);
        this.setAttenderId(attenderId);
        this.setAttenderNum(attenderNum);
        this.setAttenderName(attenderName);
        this.setSid(sid);
        this.setSname(sname);
        this.setCid(cid);
        this.setCnum(cnum);
        this.setCname(cname);
        this.setAttended_From(attended_From);
        this.setAttended_To(attended_To);
        this.setBeginTime(beginTime);
    }

    public int getAttId() {
        return attId.get();
    }

    public void setAttId(int attId) {
        this.attId.set(attId);
    }

    public int getAttenderId() {
        return attenderId.get();
    }

    public void setAttenderId(int attenderId) {
        this.attenderId.set(attenderId);
    }

    public String getAttenderNum() {
        return attenderNum.get();
    }

    public void setAttenderNum(String attenderNum) {
        this.attenderNum.set(attenderNum);
    }

    public String getAttenderName() {
        return attenderName.get();
    }

    public void setAttenderName(String attenderName) {
        this.attenderName.set(attenderName);
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

    public int getCid() {
        return cid.get();
    }

    public void setCid(int cid) {
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

    public Timestamp getAttended_From() {
        return attended_From;
    }

    public void setAttended_From(Timestamp attended_From) {
        this.attended_From = attended_From;
    }

    public Timestamp getAttended_To() {
        return attended_To;
    }

    public void setAttended_To(Timestamp attended_To) {
        this.attended_To = attended_To;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

}
