package sample.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
    private StringProperty cid = new SimpleStringProperty();
    private StringProperty cnum = new SimpleStringProperty();
    private StringProperty cname = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();

    public Course(String  cid,String cnum, String cname,String description) {
        this.setCid(cid);
        this.setCnum(cnum);
        this.setCname(cname);
        this.setDescription(description);
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

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
