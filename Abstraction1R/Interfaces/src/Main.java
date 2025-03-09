import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       Bird bird=new Bird();
       Animal animal=bird;
       FlightEnabled flier=bird;
       Trackable tracked=bird;

       animal.move();
//       flier.move();
//       tracked.move();
//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.fly();
        inFlight(flier);
        inFlight(new Jet());

        Truck  truck=new Truck();
        truck.track();

        double kmsTravelled=100;
        double milesTravelled=kmsTravelled*FlightEnabled.KM_TO_MILES;

        System.out.printf("The tuck travelled %.2f km or %.2f miles %n",kmsTravelled,milesTravelled);

        LinkedList<FlightEnabled> fliers=new LinkedList<>();
        fliers.add(bird);

        List<FlightEnabled> betterFliers=new ArrayList<>();
        betterFliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        triggerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);
    }

    private static void inFlight(FlightEnabled flight){
        flight.takeOff();
        flight.fly();

        if(flight instanceof Trackable trackable){
            trackable.track();
        }

        flight.land();
    }

    private static void triggerFliers(List<FlightEnabled> fliers){
        for (var flier:fliers
             ) {
            flier.takeOff();
        }
    }

    private static void flyFliers(List<FlightEnabled> fliers){
        for (var flier:fliers
        ) {
            flier.fly();
        }
    }

    private static void landFliers(List<FlightEnabled> fliers){
        for (var flier:fliers
        ) {
            flier.land();
        }
    }
}