package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final IntegerProperty sid = new SimpleIntegerProperty();
    private final StringProperty snum = new SimpleStringProperty();
    private final StringProperty sname = new SimpleStringProperty();
    private final StringProperty pass = new SimpleStringProperty();

    public Student(int sid, String snum, String sname) {
        this.setSid(sid);
        this.setSnum(snum);
        this.setSname(sname);

    }



    public int getSid() {
        return sid.get();
    }

    public String getSnum() {
        return snum.get();
    }

    public String getSname() {
        return sname.get();
    }

    public String getPass() {
        return pass.get();
    }

    public void setSid(int sid) {
        this.sid.set(sid);
    }

    public void setSnum(String snum) {
        this.snum.set(snum);
    }

    public void setSname(String sname) {
        this.sname.set(sname);
    }

    public void setPass(String pass) {
        this.pass.set(pass);
    }


}
