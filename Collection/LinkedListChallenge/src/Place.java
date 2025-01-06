import java.util.Comparator;

public class Place implements Comparator<Place> {

    private String name;
    private int distance;

    public Place(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)",name,distance);
    }

    @Override
    public int compare(Place o1, Place o2) {
        return o1.getDistance()- o2.getDistance();
    }
}
