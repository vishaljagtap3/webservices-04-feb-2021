package in.bitcode.webservices1;

import com.google.gson.annotations.SerializedName;

class FinalResult {

    public String status;
    public MyPlace [] results;
}

class MyPlace {
    private String business_status;
    private String vicinity;

    @SerializedName("name")
    private String placeName;

    private double rating;
    private Geometry geometry;

    public String getBusiness_status() {
        return business_status;
    }

    public void setBusiness_status(String business_status) {
        this.business_status = business_status;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "MyPlace{" +
                "business_status='" + business_status + '\'' +
                ", vicinity='" + vicinity + '\'' +
                ", name='" + placeName + '\'' +
                ", rating=" + rating +
                '}'
                +" \n" +
                geometry.toString() + "\n" +
                "---------------------------------------------------------------------------------------------";
    }
}

class Geometry {
    Location location;

    @Override
    public String toString() {
        return "Geometry{" +
                "location=" + location +
                '}';
    }
}

class Location {
    double lat, lng;

    @Override
    public String toString() {
        return "Location{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}