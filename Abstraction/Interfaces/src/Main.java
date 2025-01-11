import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bird bird=new Bird();
        Animal animal=bird;
        FlightEnabled flier=bird;
        Trackable tracked=bird;

        animal.move();
//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.land();
        inFlight(flier);
        inFlight(new Jet());
        new Truck().track();

        double kmsTravelled=100;
        double milesTravelled=kmsTravelled*FlightEnabled.KM_TO_MIlES;
        System.out.printf("The truck travelled %.2f km or %.2f miles%n",kmsTravelled,milesTravelled);

        ArrayList<FlightEnabled> fliers=new ArrayList<>();
        takingOffFlier(fliers);
        flyingfFlier(fliers);
        landingFlier(fliers);

        List<FlightEnabled> betterFliers=new ArrayList<>();
        takingOffFlier(betterFliers);
        flyingfFlier(betterFliers);
        landingFlier(betterFliers);


    }
    private static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.fly();
        if(flier instanceof Trackable trackable){
            trackable.track();
        }
        flier.land();
    }

    private static void takingOffFlier(List<FlightEnabled> flightEnableds){
        for (var f:flightEnableds
             ) {
            f.fly();
        }
    }
    private static void flyingfFlier(List<FlightEnabled> flightEnableds){
        for (var f:flightEnableds
        ) {
            f.fly();
        }
    }
    private static void landingFlier(List<FlightEnabled> flightEnableds){
        for (var f:flightEnableds
        ) {
            f.fly();
        }
    }

}