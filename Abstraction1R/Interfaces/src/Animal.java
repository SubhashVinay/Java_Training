import java.sql.SQLOutput;

enum FlightStages implements Trackable{

    GROUNDED,LAUNCH,CRUISE,DATA_COLLECTION;


    @Override
    public void track() {
        if(this != GROUNDED){
            System.out.println("Monitoring "+this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] allStages=FlightStages.values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}

record DragonFly(String name,String type) implements FlightEnabled{

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satelite implements OrbitEarth{

    public void achieveOrbit(){
        System.out.println("Orbit Achieved!");
    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();

    private static void log(String description){
        var today=new java.util.Date();
        System.out.println(today + ":"+description);
    }

    private void logStage(FlightStages stage,String description){
        description=stage+":"+description;
        log(description);
    }
}

interface FlightEnabled{

    double MILES_TO_KM=1.60934;
    double KM_TO_MILES=0.621371;

    void takeOff();
    void land();
    void fly();

    default FlightStages transition(FlightStages stages) {
//        System.out.println("Transition not implemented on "+getClass().getName());
//        return null;

        FlightStages nextStage=stages.getNextStage();
        System.out.println("Transitioning from "+stages+ " to "+nextStage);
        return nextStage;
    }
}

interface Trackable{

    void track();
}

public abstract class Animal {

    public abstract void move();
}
