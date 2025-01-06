import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<Place> placesToVisit = new LinkedList<>();
        Place place=new Place("Adelaide",1374);
        addPlace(placesToVisit,place);
        addPlace(placesToVisit,new Place("Adelaide",1374));
        addPlace(placesToVisit,new Place("Brisbane",917));
        addPlace(placesToVisit,new Place("Perth",3923));
        addPlace(placesToVisit,new Place("Alice Springs",2771));
        addPlace(placesToVisit,new Place("Darwin",3972));
        addPlace(placesToVisit,new Place("Melbourne",877));

        placesToVisit.addFirst(new Place("Sydney",0));
        System.out.println(placesToVisit);

        var iterator=placesToVisit.listIterator();
        Scanner scanner=new Scanner(System.in);
        boolean quitLoop=false;
        boolean forward=true;

        printMenu();
        while (!quitLoop){
            System.out.println("Enter Value: ");
            String menuItem=scanner.nextLine().toUpperCase().substring(0,1);

            switch (menuItem){
                case "F":
                    System.out.println("User wants to go forward");
                    break;
                case "B":
                    System.out.println("User wants to go backward");
                    break;
                case "M":
                    printMenu();
                    break;
                case "L":
                    System.out.println(placesToVisit);
                    break;
                default:
                    quitLoop=true;
                    break;
            }
        }

    }

    private static void addPlace(LinkedList<Place> places,Place place){
        if(places.contains(place)){
            System.out.println("Found Duplicate :"+place);
            return;
        }
        for (Place p:places
             ) {
            if(p.getName().equalsIgnoreCase(place.getName())){
                System.out.println("Found Duplicate :"+place);
                return;
            }
        }
        int matchedIndex=0;
        for (Place p:places
             ) {
            if(place.getDistance() < p.getDistance()){
                places.add(matchedIndex,place);
                return;
            }
            matchedIndex ++;
        }
        places.add(place);
    }

    public static void printMenu(){
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit""");
    }
}