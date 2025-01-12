interface Player{

    String name();
}
record CricketPlayer(String name, String position) implements Player{}

record FootballPlayer(String name, String position) implements Player{}

record VolleyballPlayer (String name,String position) implements Player{}
public class Main {
    public static void main(String[] args) {

        var bang=new Affiliation("city","Banglore","India");
        CricketTeam banglore1=new CricketTeam("Royal Challenger Banglore");
        CricketTeam mumbaiIndians1=new CricketTeam("Mumbai Indians");
        scoreResult(banglore1,5,mumbaiIndians1,3);

        SportsTeam banglore2=new SportsTeam("Royal Challenger Banglore");
        SportsTeam mumbaiIndians2=new SportsTeam("Mumbai Indians");
        scoreResult(banglore2,5,mumbaiIndians2,3);

        Team<CricketPlayer,Affiliation> banglore=new Team<>("Royal Challenger Banglore",bang);
        Team<CricketPlayer,Affiliation> mumbaiIndians=new Team<>("Mumbai Indians");
        scoreResult(banglore,5,mumbaiIndians,3);

        banglore.addTeamMember(new CricketPlayer("Virat","Opener"));
        banglore.addTeamMember(new CricketPlayer("Prabhudesai","1st Down batter"));
        var shreyas=new CricketPlayer("Shreyas","2nd Down");
        banglore.addTeamMember(shreyas);
        banglore.listTeamMembers();

        SportsTeam afc1=new SportsTeam("Kerala Blasters");
        Team<FootballPlayer,Affiliation> afc=new Team<>("Kerala Blasters");
        var tex=new FootballPlayer("Tex Walker","Centre Half Forward");
        afc.addTeamMember(tex);
        var rory=new FootballPlayer("Rory Laird","Mid Fielder");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<VolleyballPlayer,Affiliation> adelaide=new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts","Setter"));
        adelaide.listTeamMembers();

        var canberra=new Team<VolleyballPlayer,Affiliation>("Canberrs Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black","Opposite"));
        canberra.listTeamMembers();

        scoreResult(canberra,0,adelaide,1);
    }

    public static void scoreResult(CricketTeam c1,int c1_Score,CricketTeam c2,int c2_score){
        String message=c1.setScore(c1_Score,c2_score);
        c2.setScore(c2_score,c1_Score);
        System.out.printf("%s %s %s %n",c1,message,c2);
    }
    public static void scoreResult(SportsTeam c1,int c1_Score,SportsTeam c2,int c2_score){
        String message=c1.setScore(c1_Score,c2_score);
        c2.setScore(c2_score,c1_Score);
        System.out.printf("%s %s %s %n",c1,message,c2);
    }

    public static void scoreResult(Team c1,int c1_Score,Team c2,int c2_score){
        String message=c1.setScore(c1_Score,c2_score);
        c2.setScore(c2_score,c1_Score);
        System.out.printf("%s %s %s %n",c1,message,c2);
    }
}