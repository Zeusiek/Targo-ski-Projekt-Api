package GetData;

public class Localization {
    private String region;
    private String subregion;
    private double latitude;
    private double longitude;

    public Localization(String region, String subregion, double latitude, double longitude){
        setRegion(region);
        setSubregion(subregion);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public String getSubregion() {
        return subregion;
    }
    public String getRegion() {
        return region;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }


    @Override
    public String toString() {
        return "Localization{" +
                "region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
