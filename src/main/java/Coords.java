/**
 * Created by Matt on 2017-08-15.
 */
public class Coords {
    private int lon;
    private int lat;

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }


    @Override
    public String toString() {
        return "Coords{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
