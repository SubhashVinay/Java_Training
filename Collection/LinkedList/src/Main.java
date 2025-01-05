import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit=new LinkedList<>();
        placesToVisit.add("Sydney");
        placesToVisit.add(0,"Canberra");
        System.out.println(placesToVisit);
        addMoreMethods(placesToVisit);
        System.out.println(placesToVisit);
//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

        //gettingElements(placesToVisit);

        //printItinerary(placesToVisit);
        //printItinerary2(placesToVisit);
        //printItinerary3(placesToVisit);
        testIterator(placesToVisit);

    }

    private static void testIterator(LinkedList<String> list) {
//        var iterator=list.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next().equals("Brisbane")){
//                iterator.remove();
//            }
//        }
        var iterator=list.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("Brisbane")){
                iterator.add("Lake Wivenhoe");
            }
        }
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(list);
    }

    private static void addMoreMethods(LinkedList<String> list){
        list.addFirst("Darwin");
        list.addLast("Hobart");

        //queue
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");

        //stack methods
        list.push("Alice Springs");
    }

    private static void removeElements(LinkedList<String> list){
        list.remove(4);
        list.remove("Brisbane");

        list.remove();
        list.removeFirst();
        list.removeLast();

        list.poll();
        list.pollFirst();
        list.pollLast();

        list.push("sydney");
        list.push("Brisbane");
        list.push("Canberra");

        String p4=list.pop();
        System.out.println(p4);
    }

    private static void gettingElements(LinkedList<String> list){
        System.out.println("Retrieved Element = "+list.get(4));

        System.out.println("First Element "+list.getFirst());
        System.out.println("Last Element "+list.getLast());

        System.out.println("Darwin is at position "+list.indexOf("Darwin"));
        System.out.println("melbourne is at position "+list.lastIndexOf("Melbourne"));

        //Queue Retrieval Method
        System.out.println("Element from element() = "+list.element());

        //Stack Retrieval Methods
        System.out.println("Element from peek() = "+list.peek());
        System.out.println("Element from peekFirst() ="+list.peekFirst());
        System.out.println("Element from peekLast() = "+list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list){
        System.out.println("Trip Starts at "+list.getFirst());

        for(int i=1;i<list.size();i++){
            System.out.println("--> From: "+list.get(i-1)+ " to "+list.get(i));
        }

        System.out.println("Trip Ends at "+list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list){
        System.out.println("Trip Starts at "+list.getFirst());
        String previousTown=list.getFirst();
        for (String town:list
             ) {
            System.out.println("--> From: "+previousTown+ " to "+town);
            previousTown=town;
        }
        System.out.println("Trip Ends at "+list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list){
        System.out.println("Trip Starts at "+list.getFirst());
        String previousTown=list.getFirst();
        ListIterator<String> iterator=list.listIterator(1);

        while (iterator.hasNext()){
            var town=iterator.next();
            System.out.println("--> From: "+previousTown+ " to "+town);
            previousTown=town;
        }
        System.out.println("Trip Ends at "+list.getLast());
    }
}