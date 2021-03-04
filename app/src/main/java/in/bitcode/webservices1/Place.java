package in.bitcode.webservices1;

public class Place {
    public String name, vicinity;
    public float rating;
    public double lat, lng;

    public Place(String name, String vicinity, float rating, double lat, double lng) {
        this.name = name;
        this.vicinity = vicinity;
        this.rating = rating;
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", vicinity='" + vicinity + '\'' +
                ", rating=" + rating +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
