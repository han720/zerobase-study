package wifi;

public class DbHistory {

    public int id;
    public String myLnt; // y
    public String myLat; // x
    public String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyLnt() {
        return myLnt;
    }

    public void setMyLnt(String myLnt) {
        this.myLnt = myLnt;
    }

    public String getMyLat() {
        return myLat;
    }

    public void setMyLat(String myLat) {
        this.myLat = myLat;
    }
}
