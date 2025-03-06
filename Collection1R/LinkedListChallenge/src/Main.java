import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public record Place(String name,int distance){

        @Override
        public String toString() {
            return String.format("%s (%d)",name,distance);
        }
    }
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit=new LinkedList<>();
        Place adelaide=new Place("Adelaide",1374);
        addPlaces(placesToVisit,adelaide);
        addPlaces(placesToVisit,new Place("adelaide",1374));
        addPlaces(placesToVisit,new Place("Brisbane",917));
        addPlaces(placesToVisit,new Place("Perth",3923));
        addPlaces(placesToVisit,new Place("Alice Springs",2771));
        addPlaces(placesToVisit,new Place("Darwin",3972));
        addPlaces(placesToVisit,new Place("Melbourne",877));

        placesToVisit.addFirst(new Place("Sydney",0));
        System.out.println(placesToVisit);

        var iterator=placesToVisit.listIterator();
        Scanner scanner=new Scanner(System.in);
        boolean quitLoop=false;
        boolean forward=true;

        printMenu();

        while (!quitLoop){
            if(!iterator.hasPrevious()){
                System.out.println("Originating "+iterator.next());
                forward=true;
            }
            if(!iterator.hasNext()){
                System.out.println("Final "+iterator.previous());
                forward=false;
            }
            System.out.println("Enter Value!");
            String menuItem=scanner.nextLine().toUpperCase().substring(0,1);

            switch (menuItem){
                case "F":
                    System.out.println("User Wants to go forward!");
                    if(!forward){
                        forward=true;
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
                case "B":
                    if(forward){
                        forward=false;
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    System.out.println("User Wants to go backward!");
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                case "L":
                    System.out.println(placesToVisit);
                    break;
                case "M":
                    printMenu();
                    break;
                default:
                    quitLoop=true;

            }
        }

    }

    private static void addPlaces(LinkedList<Place> list,Place place){
        if(list.contains(place)){
            System.out.println("Found Duplicate: "+place);
            return;
        }

        for(Place p:list){
            if(p.name.equalsIgnoreCase(place.name)){
                System.out.println("Found Duplicate: "+place);
                return;
            }
        }

        int matchedIndex=0;
        for (Place p:list
        ) {
            if(place.distance < p.distance){
                list.add(matchedIndex,place);
                return;
            }
            matchedIndex ++;
        }
        list.add(place);
    }

    private static void printMenu(){
        String test= """
                Available Action (Select word or letter):
                (F)orward
                (B)ackwards
                (L)ist places
                (M)enu
                (Q)uit""";
        System.out.println(test);
    }
}